package com.pierre.hexagonal.adapters.in.controller;


import com.pierre.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.pierre.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.pierre.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.pierre.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.pierre.hexagonal.application.ports.out.InsertCustomerOutputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerOutputPort insertCustomerOutputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){

        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerOutputPort.insert(customer,customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }


}
