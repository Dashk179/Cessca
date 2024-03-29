package com.example.cessca.Service;

import com.example.cessca.Dto.NormDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public interface NormService {
    String addNorm(NormDto normDto);
    String deleteNorm(NormDto normDto);

    String updateNorm(NormDto normDto);
    List<NormDto> getAllNormsNames();

}
