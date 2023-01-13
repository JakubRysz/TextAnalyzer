package com.project.textAnalyzer.service;

import com.project.textAnalyzer.model.RepetitionsAndPositions;
import com.project.textAnalyzer.model.Text;
import com.project.textAnalyzer.model.WordInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.Collator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class TextService {

    private int position;
    private Map<String, RepetitionsAndPositions> wordsInfoMap;
    private final static String REGEX = "\\b(\\p{L}+[1-9]*)+|([1-9]*\\p{L}+)+\\b";
    private final static Locale LOCALE = new Locale("pl", "PL");


    public List<WordInfo> analyze(Text text) {
        wordsInfoMap = new HashMap<>();
        position = 1;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text.getTekst());
        while(matcher.find()) {
            analyzeWord(matcher.group());
        }

        return mapToWordInfoList(
                sortWordInfoMap());
    }

    private void analyzeWord(String word) {

        if (wordsInfoMap.containsKey(word)) {
            wordsInfoMap.get(word).addPosition(position);
            position++;
            return;
        }

        List<Integer> newPositions = new ArrayList<>();
        newPositions.add(position);
        RepetitionsAndPositions repetitionsAndPositions = new RepetitionsAndPositions(1, newPositions);
        wordsInfoMap.put(word, repetitionsAndPositions);
        position++;
    }

    private Map<String, RepetitionsAndPositions> sortWordInfoMap() {
        Collator plCollator = Collator.getInstance(LOCALE);
        TreeMap<String, RepetitionsAndPositions> sorted = new TreeMap<>(plCollator);
        sorted.putAll(wordsInfoMap);
        return sorted;
    }

    private List<WordInfo> mapToWordInfoList(Map<String, RepetitionsAndPositions> map) {

        List<WordInfo> wordInfoList = new ArrayList<>();
        map.forEach((key, value) -> wordInfoList.add(
                new WordInfo(key, value.getRepetitionCount(), value.getPositions())));
        return wordInfoList;
    }

}