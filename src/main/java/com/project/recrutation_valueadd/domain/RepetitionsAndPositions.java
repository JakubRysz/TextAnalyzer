package com.project.recrutation_valueadd.domain;

import java.util.List;

public class RepetitionsAndPositions {

    private int repetitionCount;
    private List<Integer> positions;

    public RepetitionsAndPositions(int repetitionCount, List<Integer> positions) {
        this.repetitionCount = repetitionCount;
        this.positions = positions;
    }

    public int getRepetitionCount() {
        return repetitionCount;
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public void setRepetitionCount(int repetitionCount) {
        this.repetitionCount = repetitionCount;
    }

    public void setPositions(List<Integer> positions) {
        this.positions = positions;
    }
}
