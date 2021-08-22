package com.example.ddd.learn.sample03.ddd.domain.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User("hoge");
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    @DisplayName("ユーザは名前で識別できる。名前が同じなら同じユーザとみなす")
    void testEquals1() {
        User sameUser = new User("hoge");
        assertEquals(sameUser, user);
    }

    @Test
    @DisplayName("ユーザは名前で識別できる。名前が異なるなら別のユーザとみなす")
    void testEquals2() {
        User anotherUser = new User("fuga");
        assertNotEquals(anotherUser, user);
    }

    @Test
    @DisplayName("ユーザから名前を取得できる")
    void getName() {
        assertEquals("hoge", user.getName());
    }

    @Test
    @DisplayName("ユーザは複数の足し算の履歴を保持する")
    void testHistory() {
        AdditionElement e11 = new AdditionElement(1);
        AdditionElement e21 = new AdditionElement(2);
        AdditionElement result1 = new AdditionElement(3);
        user.addHistory(e11, e21, result1);

        AdditionElement e12 = new AdditionElement(3);
        AdditionElement e22 = new AdditionElement(4);
        AdditionElement result2 = new AdditionElement(7);
        user.addHistory(e12, e22, result2);

        List<AdditionFormula> expected = new ArrayList<>(Arrays.asList(
                new AdditionFormula(e11, e21, result1),
                new AdditionFormula(e12, e22, result2)
        ));
        assertEquals(expected, user.getHistory());
    }
}