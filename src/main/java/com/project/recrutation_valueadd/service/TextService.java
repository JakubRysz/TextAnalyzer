package com.project.recrutation_valueadd.service;

import com.project.recrutation_valueadd.domain.RepetitionsAndPositions;
import com.project.recrutation_valueadd.domain.Text;
import com.project.recrutation_valueadd.domain.TextInfo;
import com.project.recrutation_valueadd.domain.WordInfo;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.*;

@Service
public class TextService {

    public TextInfo analyzeText(Text text) {

        String[] words = text.getTekst().split("[\\s\\!\"“”„\\#$%&'()*+,\\-–./:;<=>?@\\[\\\\\\]^_\s‘{|}~]+");

        Map<String, RepetitionsAndPositions> wordsInfoMap = new HashMap<>();
        int position = 1;

        for (String word : words) {

            if (!wordsInfoMap.containsKey(word)) {
                List<Integer> newPositions = new ArrayList<>();
                newPositions.add(position);
                RepetitionsAndPositions repetitionsAndPositions = new RepetitionsAndPositions(1, newPositions);
                wordsInfoMap.put(word, repetitionsAndPositions);
            } else {
                RepetitionsAndPositions repetitionsAndPositions2 = wordsInfoMap.get(word);
                repetitionsAndPositions2.setRepetitionCount(repetitionsAndPositions2.getRepetitionCount() + 1);
                repetitionsAndPositions2.getPositions().add(position);

                wordsInfoMap.put(word, repetitionsAndPositions2);
            }
            position++;
        }

        Collator plCollator = Collator.getInstance(new Locale("pl", "PL"));
        TreeMap<String, RepetitionsAndPositions> sorted = new TreeMap<>(plCollator);
        sorted.putAll(wordsInfoMap);

        return mapToTextInfo(sorted);
    }


    private TextInfo mapToTextInfo(Map<String, RepetitionsAndPositions> map) {
        TextInfo textInfo = new TextInfo();
        for (Map.Entry<String, RepetitionsAndPositions> entry : map.entrySet()) {
            textInfo.getWordInfoList().add(
                    new WordInfo(entry.getKey(), entry.getValue().getRepetitionCount(), entry.getValue().getPositions()));
        }
        return textInfo;
    }

}

