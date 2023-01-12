package com.project.textAnalyzer.controller;

import com.project.textAnalyzer.domain.Text;
import com.project.textAnalyzer.domain.WordInfo;
import com.project.textAnalyzer.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;
    private final Validator validator;

    @PostMapping("/analyze")
    public List<WordInfo> analyzeText(@RequestBody Text text) {
        validator.validateText(text);
        System.out.println(text.getTekst());
    return textService.analyzeText(text);
    }

}
