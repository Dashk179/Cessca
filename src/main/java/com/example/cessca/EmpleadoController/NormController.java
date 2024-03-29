package com.example.cessca.EmpleadoController;

import com.example.cessca.Dto.NormDto;
import com.example.cessca.Service.NormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(path = "cessca/v1/norm")
public class NormController {
    private final NormService normService;

    public NormController(NormService normService) {
        this.normService = normService;
    }

    @PostMapping(path = "/save")
    public String addNorm(@RequestBody NormDto normDto){
        String id = normService.addNorm(normDto);
        return id;
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Void> deleteNorm(@RequestBody NormDto normDto){
        log.info("El id del la norma es" +normDto.getNormId());
        this.normService.deleteNorm(normDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update")
    public String updateNorm(@RequestBody NormDto normDto){
        String id = normService.updateNorm(normDto);
        return id;
    }

    @GetMapping("/allNames")
    public List<NormDto> getAllNormsNames() {
        return normService.getAllNormsNames();
    }


        }
