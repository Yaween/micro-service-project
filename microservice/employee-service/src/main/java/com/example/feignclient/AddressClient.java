package com.example.feignclient;


import com.example.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/address-service")
public interface AddressClient {

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("id") int id);

}

