package com.geekbrains.spring.web.endpoints;

import com.geekbrains.spring.web.services.ProductsService;
import com.geekbrains.spring.web.services.UserService;
import com.geekbrains.spring.web.soap.GetAllUsersRequest;
import com.geekbrains.spring.web.soap.GetAllUsersResponse;
import com.geekbrains.spring.web.soap.Product;
import com.geekbrains.spring.web.soap.User;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://www.mvg.com/spring/ws/products";

    private final ProductsService productsService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request){
        GetAllProductsResponse response = new GetAllProductsResponse();
        productsService.findAll().forEach(u -> {
            Product product = new Product();
            product.setTitle(u.getTitle());
            product.setPrice(u.getPrice());
            response.getProducts().add(product);
        });
        return response;
    }
}
