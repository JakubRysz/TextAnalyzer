package com.project.recrutation_valueadd.controller;

import com.project.recrutation_valueadd.domain.Text;
import com.project.recrutation_valueadd.domain.TextInfo;
import com.project.recrutation_valueadd.domain.WordInfo;
import com.project.recrutation_valueadd.service.TextService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TextController {

    private final TextService textService;
    private final Validator validator;

    public TextController(TextService textService, Validator validator) {
        this.textService = textService;
        this.validator = validator;
    }

    @PostMapping("/analyze")
    public List<WordInfo> analyzeText(@RequestBody Text text) {
        validator.validateText(text);
    return textService.analyzeText(text).getWordInfoList();
    }

}
