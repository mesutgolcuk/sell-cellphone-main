package com.mesutgolcuk.sellcellphone.service;

import com.mesutgolcuk.sellcellphone.entity.CustomerEntity;
import com.mesutgolcuk.sellcellphone.exception.NoContentFoundException;
import com.mesutgolcuk.sellcellphone.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    ICustomerRepo customerRepo;

    public List<CustomerEntity> getAllCustomers() throws Exception {
        List<CustomerEntity> list = customerRepo.findAll();
        if (list.isEmpty()) {
            throw new NoContentFoundException();
        }
        return list;
    }

    public void saveCustomer(CustomerEntity customer) {
        customerRepo.save(customer);
    }
}
