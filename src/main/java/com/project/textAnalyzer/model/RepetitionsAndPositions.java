package com.project.textAnalyzer.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class RepetitionsAndPositions {
    private int repetitionCount;
    private List<Integer> positions;

    public void addPosition(Integer position) {
        if (position == null) {
            return;
        }

        repetitionCount++;

        if (positions == null) {
            positions = new ArrayList<>();
        }
        positions.add(position);
    }
}
