package com.project.recrutation_valueadd.domain;

import java.util.ArrayList;
import java.util.List;

public class TextInfo {

    private List<WordInfo> wordInfoList = new ArrayList<>();

    public List<WordInfo> getWordInfoList() {
        return wordInfoList;
    }

    public void setWordInfoList(List<WordInfo> wordInfoList) {
        this.wordInfoList = wordInfoList;
    }
}
