package com.example.cessca.Service;

import com.example.cessca.Dto.UserDto;
import com.example.cessca.Dto.LoginDto;
import com.example.cessca.Response.LoginResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service

public interface UserService {
    String addUser(UserDto userDto);
   String deleteUser(UserDto userDto);

   List<String> getAllNormsNames();
    LoginResponse loginUser(LoginDto loginDto);
}
