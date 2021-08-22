package com.example.ddd.learn.sample01.ddd.domain.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionElementTest {

    @Test
    @DisplayName("要素から値を取得できる")
    void getValue() {
        AdditionElement target = new AdditionElement(1);
        assertEquals(1, target.getValue());
    }

    @Test
    @DisplayName("要素どうしを足すと、足し算結果の値を持つ要素を返す")
    void plus() {
        AdditionElement element1 = new AdditionElement(1);
        AdditionElement element2 = new AdditionElement(2);
        AdditionElement expected = new AdditionElement(1 + 2);
        assertEquals(expected, element1.plus(element2));
    }
}