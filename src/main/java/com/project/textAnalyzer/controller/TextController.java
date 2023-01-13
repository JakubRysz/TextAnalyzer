package com.project.textAnalyzer.controller;

import com.project.textAnalyzer.model.Text;
import com.project.textAnalyzer.model.WordInfo;
import com.project.textAnalyzer.service.TextService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping("/analyze")
    public List<WordInfo> analyzeText(@Validated @RequestBody Text text) {
    return textService.analyze(text);
    }
}
