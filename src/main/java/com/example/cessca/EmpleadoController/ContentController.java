package com.example.cessca.EmpleadoController;

import com.example.cessca.Dto.ContentDto;
import com.example.cessca.Service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("cessca/v1/content")
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }


    @PostMapping(path = "/save")
    public String addContent(@RequestBody ContentDto contentDto){
        String id = String.valueOf(contentService.createContent(contentDto));
        return id;
    }
}
