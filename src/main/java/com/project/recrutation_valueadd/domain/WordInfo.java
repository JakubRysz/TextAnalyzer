package com.project.recrutation_valueadd.domain;

import java.util.List;
import java.util.Objects;

public class WordInfo {
    private String slowo;
    private int powtorzenia;
    private List<Integer> pozycje;

    public WordInfo(String slowo, int powtorzenia, List<Integer> pozycje) {
        this.slowo = slowo;
        this.powtorzenia = powtorzenia;
        this.pozycje = pozycje;
    }

    public String getSlowo() {
        return slowo;
    }

    public int getPowtorzenia() {
        return powtorzenia;
    }

    public List<Integer> getPozycje() {
        return pozycje;
    }

    public void setSlowo(String slowo) {
        this.slowo = slowo;
    }

    public void setPowtorzenia(int powtorzenia) {
        this.powtorzenia = powtorzenia;
    }

    public void setPozycje(List<Integer> pozycje) {
        this.pozycje = pozycje;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordInfo wordInfo = (WordInfo) o;
        return powtorzenia == wordInfo.powtorzenia && Objects.equals(slowo, wordInfo.slowo) && Objects.equals(pozycje, wordInfo.pozycje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slowo, powtorzenia, pozycje);
    }
}
