package com.project.recrutation_valueadd.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class RepetitionsAndPositions {

    private int repetitionCount;
    private List<Integer> positions;

}
