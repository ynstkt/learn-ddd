package com.example.ddd.learn.sample03.ddd.usecase;

import com.example.ddd.learn.sample03.ddd.domain.models.AdditionElement;
import com.example.ddd.learn.sample03.ddd.domain.models.User;
import com.example.ddd.learn.sample03.ddd.domain.repositories.UserRepository;
import com.example.ddd.learn.sample03.ddd.domain.repositories.UserRepositoryException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdditionServiceTest {

    UserRepository mockUserRepository;
    AdditionService service;

    @BeforeEach
    void setUp() {
        mockUserRepository = mock(UserRepository.class);
        service = new AdditionService(mockUserRepository);
    }

    @AfterEach
    void tearDown() {
        service = null;
        mockUserRepository = null;
    }

    @Test
    @DisplayName("足し算サービスを実行すると、足し算の結果を返却する")
    void execute() {
        try {
            when(mockUserRepository.find(anyString())).thenReturn(new User("hoge"));
            assertEquals(3, service.execute("hoge", 1, 2));
        } catch (AdditionServiceException | UserRepositoryException e) {
            fail();
        }
    }

    @Test
    @DisplayName("足し算サービスを実行すると、足し算の履歴を持つユーザを保存する")
    void executeSuccess() {
        try {
            when(mockUserRepository.find(anyString())).thenReturn(new User("hoge"));

            service.execute("hoge",1,2);

            User expectedUser = new User("hoge");
            expectedUser.addHistory(
                new AdditionElement(1),
                new AdditionElement(2),
                new AdditionElement(3)
            );

            verify(mockUserRepository).find("hoge");
            verify(mockUserRepository).save(expectedUser);
        } catch (AdditionServiceException | UserRepositoryException e) {
            fail();
        }
    }

    @Test
    @DisplayName("パラメータが不正だと、足し算サービスが失敗する")
    void executeFailure1() throws UserRepositoryException {
        when(mockUserRepository.find(anyString())).thenReturn(new User("hoge"));
        assertThrows(AdditionServiceException.class, () -> {
            service.execute("hoge",1, -2);
        });
    }

    @Test
    @DisplayName("ユーザの保存が失敗すると、足し算サービスが失敗する")
    void executeFailure2() throws UserRepositoryException {
        when(mockUserRepository.find(anyString())).thenReturn(new User("hoge"));
        doThrow(new UserRepositoryException(new IOException()))
                .when(mockUserRepository).save(any());
        assertThrows(AdditionServiceException.class, () -> {
            service.execute("hoge",1,2);
        });
    }
}

