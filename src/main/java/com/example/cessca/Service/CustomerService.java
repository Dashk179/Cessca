package com.example.cessca.Service;

import com.example.cessca.Dto.CustomerDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public interface CustomerService {
    String addCustomer(CustomerDto customerDto);
    String deleteCustomer(CustomerDto customerDto);

    String updateCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomers();




}
