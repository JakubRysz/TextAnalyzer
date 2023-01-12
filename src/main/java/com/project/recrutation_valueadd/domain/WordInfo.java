package com.project.recrutation_valueadd.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class WordInfo {
    private String slowo;
    private int powtorzenia;
    private List<Integer> pozycje;

}
