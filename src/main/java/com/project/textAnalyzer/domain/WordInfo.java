package com.project.textAnalyzer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class WordInfo {
    private String slowo;
    private int powtorzenia;
    private List<Integer> pozycje;
}
