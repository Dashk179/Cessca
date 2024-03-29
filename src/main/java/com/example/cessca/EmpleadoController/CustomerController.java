package com.example.cessca.EmpleadoController;

import com.example.cessca.Dto.CustomerDto;
import com.example.cessca.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(path = "cessca/v1/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDto customerDto){
        String id = customerService.addCustomer(customerDto);
        return id;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCustomer(@RequestBody CustomerDto customerDto){
        log.info("ID del cliente a eliminar: {}", customerDto.getCustomerId());
        this.customerService.deleteCustomer(customerDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDto customerDto){
        String id = customerService.updateCustomer(customerDto);
        return id;
    }

    @GetMapping("/allCustomer")
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
