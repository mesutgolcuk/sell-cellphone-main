package com.mesutgolcuk.sellcellphone.controller;

import com.mesutgolcuk.sellcellphone.entity.CustomerEntity;
import com.mesutgolcuk.sellcellphone.model.CustomersResponse;
import com.mesutgolcuk.sellcellphone.model.RegisterCustomerResponse;
import com.mesutgolcuk.sellcellphone.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private static Logger LOGGER = LogManager.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @PostMapping("/api/customer")
    public ResponseEntity<RegisterCustomerResponse> saveCustomer(@RequestBody CustomerEntity customer) {
        RegisterCustomerResponse response = new RegisterCustomerResponse();
        customerService.saveCustomer(customer);
        LOGGER.info("New customer created");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/api/customers")
    public ResponseEntity<CustomersResponse> getAllCustomers() throws Exception {
        CustomersResponse response = new CustomersResponse();
        List<CustomerEntity> customerList = customerService.getAllCustomers();
        response.setCustomerList(customerList);
        response.setSuccess(true);
        LOGGER.info("Returned all customers");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
