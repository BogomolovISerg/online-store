package com.geekbrains.spring.web.endpoints;

import com.geekbrains.spring.web.services.UserService;
import com.geekbrains.spring.web.soap.GetAllUsersRequest;
import com.geekbrains.spring.web.soap.GetAllUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.geekbrains.spring.web.soap.User;

@Endpoint
@RequiredArgsConstructor
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://www.mvg.com/spring/ws/users";
    private final UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(@RequestPayload GetAllUsersRequest request){
        GetAllUsersResponse response = new GetAllUsersResponse();
        userService.findAllUsers().forEach(u -> {
            User user = new User();
            user.setUsername(u.getUsername());
            user.setPassword(u.getPassword());
            user.setEmail(u.getEmail());
            response.getUsers().add(user);
        });
        return response;
    }
}
