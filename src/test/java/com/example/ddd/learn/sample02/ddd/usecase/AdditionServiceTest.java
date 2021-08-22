package com.example.ddd.learn.sample02.ddd.usecase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionServiceTest {

    AdditionService service;

    @BeforeEach
    void setUp() {
        service = new AdditionService();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    @Test
    @DisplayName("足し算サービスを実行すると、足し算の結果を返却する")
    void execute() {
        try {
            assertEquals(3, service.execute(1, 2));
        } catch (AdditionServiceException e) {
            fail();
        }
    }

    @Test
    @DisplayName("パラメータが不正だと、足し算サービスが失敗する")
    void executeFailure() {
        assertThrows(AdditionServiceException.class, () -> {
            service.execute(1, -2);
        });
    }
}