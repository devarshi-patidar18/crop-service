package com.agrosense.crop.crop_service.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8080") // URL of UserService
public interface UserServiceClient {

    @GetMapping("/users/{id}") // Endpoint in UserService
    Object getUserById(@PathVariable("id") Long id);
}