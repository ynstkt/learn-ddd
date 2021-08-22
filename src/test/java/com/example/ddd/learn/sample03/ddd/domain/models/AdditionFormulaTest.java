package com.example.ddd.learn.sample03.ddd.domain.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionFormulaTest {

    AdditionFormula target;

    @BeforeEach
    void setUp() {
        target = new AdditionFormula(
                new AdditionElement(1),
                new AdditionElement(2),
                new AdditionElement(3)
        );
    }

    @AfterEach
    void tearDown() {
        target = null;
    }

    @Test
    @DisplayName("１つ目の要素の値を取得できる")
    void getElement1Value() {
        assertEquals(1, target.getElement1Value());
    }

    @Test
    @DisplayName("２つ目の要素の値を取得できる")
    void getElement2Value() {
        assertEquals(2, target.getElement2Value());
    }

    @Test
    @DisplayName("足し算結果の値を取得できる")
    void getResultValue() {
        assertEquals(3, target.getResultValue());
    }
}