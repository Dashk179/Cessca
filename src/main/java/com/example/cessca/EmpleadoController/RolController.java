package com.example.cessca.EmpleadoController;

import com.example.cessca.Dto.RolDto;
import com.example.cessca.Service.RolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(path = "cessca/v1/rol")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService){
        this.rolService = rolService;
    }

    @PostMapping(path = "/add")
    public String addRol(@RequestBody RolDto rolDto){
        String id = rolService.addRol(rolDto);
        return rolDto.getName();
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteRol(@RequestBody RolDto rolDto){
        log.info("El ID del rol a eliminar:{}" , rolDto.getRolId());
        this.rolService.deleteRol(rolDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/allRol")
    public List<String> getAllRols(){
        return rolService.getAllRol();
    }
}
