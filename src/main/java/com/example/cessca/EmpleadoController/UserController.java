package com.example.cessca.EmpleadoController;

import com.example.cessca.Dto.UserDto;
import com.example.cessca.Dto.LoginDto;
import com.example.cessca.Response.LoginResponse;
import com.example.cessca.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(path = "cessca/v1/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto){
        String id = userService.addUser(userDto);
        return id;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@RequestBody UserDto userDto){
        log .info("ID del usuario a elliminar{}" ,userDto.getUserId());
        this.userService.deleteUser(userDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> loginEmpleado(@RequestBody LoginDto loginDto) {
        // Lógica para manejar la solicitud de inicio de sesión
        LoginResponse loginResponse = userService.loginUser(loginDto);
        // Retorna una respuesta con el código de estado OK y el objeto LoginResponse en el cuerpo
        return ResponseEntity.ok(loginResponse);
    }


    @GetMapping(path = "/allUser")
    public List<String > getAllUsersNames(){
    return userService.getAllNormsNames();
    }
}
