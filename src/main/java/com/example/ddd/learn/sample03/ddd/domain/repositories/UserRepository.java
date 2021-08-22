package com.example.ddd.learn.sample03.ddd.domain.repositories;

import com.example.ddd.learn.sample03.ddd.domain.models.User;

public interface UserRepository {
    void save(User user) throws UserRepositoryException;
    User find(String name) throws UserRepositoryException;
}
