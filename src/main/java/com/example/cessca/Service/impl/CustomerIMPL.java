package com.example.cessca.Service.impl;

import com.example.cessca.Dto.CustomerDto;
import com.example.cessca.Entity.CustomerEntity;
import com.example.cessca.Entity.UserEntity;
import com.example.cessca.Repository.CustomerRepository;
import com.example.cessca.Repository.UserRepository;
import com.example.cessca.Service.CustomerService;
import com.example.cessca.util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerIMPL implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public String addCustomer(CustomerDto customerDto) {
// Obtén el UserEntity correspondiente al usercessca_id del DTO
        log.info("userCessca:  {}", customerDto.getUserId());
        UserEntity userEntity = userRepository.findById(customerDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("No se encontró el usuario con ID: " + customerDto.getUserId()));

        var customerEntity = CustomerEntity.builder()
                .id(customerDto.getCustomerId())
                .rfc(customerDto.getRfc())
                .denomination(customerDto.getDenomination())
                .address(customerDto.getAddress())
                .password(this.passwordEncoder.encode(customerDto.getPassword()))
                .userId(userEntity).build();

        // Guarda la CustomerEntity en la base de datos
        customerRepository.save(customerEntity);

        return customerEntity.getRfc();
    }

    @Override
    public String deleteCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerRepository.findById(customerDto.getCustomerId()).
                orElseThrow(() -> new NoSuchElementException("No se encontró el cliente con ID: " + customerDto.getCustomerId()));
        this.customerRepository.deleteById(customerEntity.getId());
        return customerDto.getRfc();
    }

    @Override
    public String updateCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerRepository.findById(customerDto.getCustomerId())
                .orElseThrow(() -> new IdNotFoundException("Customer"));
        customerEntity.setRfc(customerDto.getRfc());
        customerEntity.setDenomination(customerDto.getAddress());
        customerEntity.setAddress(customerDto.getAddress());
        var message = ("El cliente: " + customerDto.getDenomination() + "ha sido actualizado correctamente");
        return message;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }
    private CustomerDto mapToCustomerDto(CustomerEntity customerEntity) {
        return CustomerDto.builder()
                .customerId(customerEntity.getId())
                .rfc(customerEntity.getRfc())
                .denomination(customerEntity.getDenomination())
                .address(customerEntity.getAddress())
                .password("**************")
                // Añadir cualquier otro campo que desees incluir en el DTO
                .build();
    }

}
