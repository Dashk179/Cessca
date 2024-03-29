package com.example.cessca.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerDto {
    private int customerId;
    private int userId;
    private String rfc;
    private String denomination;
    private String address;
    private String password;

}
