package com.example.cessca.Service;

import com.example.cessca.Dto.RolDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public interface RolService {
    String addRol(RolDto rolDto);

    String deleteRol(RolDto rolDto);
    List<String>getAllRol();

}
