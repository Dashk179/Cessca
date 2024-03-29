package com.example.cessca.Service;

import com.example.cessca.Dto.ContentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface ContentService {
int createContent(ContentDto contentDto);

}
