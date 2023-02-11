package com.matixtech.productorderservice.service;

import com.matixtech.productorderservice.dto.InventoryResponse;
import com.matixtech.productorderservice.dto.OrderLineItemsDto;
import com.matixtech.productorderservice.dto.OrderRequest;
import com.matixtech.productorderservice.model.Order;
import com.matixtech.productorderservice.model.OrderLineItems;
import com.matixtech.productorderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLines(orderLineItems);

        List<String> skuCodes = order.getOrderLines().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        //call inventory service, and place order if product is in stock
        InventoryResponse[] inventoryResponsesArray = webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        boolean allProductsInStock = Arrays.stream(inventoryResponsesArray)
                .allMatch(InventoryResponse::isInStock);
        if (allProductsInStock){
            orderRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("product is not present in stock please choose available one");
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }
}
