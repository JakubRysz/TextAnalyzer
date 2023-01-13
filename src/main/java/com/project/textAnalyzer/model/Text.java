package com.project.textAnalyzer.model;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class Text {
    @NonNull
    private String tekst;
}
