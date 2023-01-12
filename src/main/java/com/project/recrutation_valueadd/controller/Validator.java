package com.project.recrutation_valueadd.controller;

import com.project.recrutation_valueadd.domain.Text;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class Validator {
    public void validateText(Text text) {
        if (text.getTekst()==null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Text is null");
        }

        if (text.getTekst().length()<1) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Text is empty");
        }

    }
}
