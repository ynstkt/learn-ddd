package com.example.ddd.learn.sample03.ddd.usecase;

import com.example.ddd.learn.sample03.ddd.domain.models.AdditionElement;
import com.example.ddd.learn.sample03.ddd.domain.models.User;
import com.example.ddd.learn.sample03.ddd.domain.repositories.UserRepository;
import com.example.ddd.learn.sample03.ddd.domain.repositories.UserRepositoryException;

public class AdditionService {

    private final UserRepository userRepository;

    public AdditionService(UserRepository userRepository){
        this.userRepository = userRepository; // リポジトリ実装をDI
    }

    public int execute(String username, int int1, int int2) throws AdditionServiceException {
        try {
            // ドメインオブジェクトを生成
            final AdditionElement e1 = new AdditionElement(int1); // 値オブジェクト
            final AdditionElement e2 = new AdditionElement(int2); // 値オブジェクト

            // ドメインオブジェクトに処理を委譲
            final AdditionElement result = e1.plus(e2); // 値オブジェクトのメソッド戻り値も値オブジェクト
            final User user = this.userRepository.find(username);
            user.addHistory(e1, e2, result); // エンティティを更新
            this.userRepository.save(user); // エンティティをリポジトリで永続化

            return result.getValue();
        } catch (IllegalArgumentException | UserRepositoryException e) {
            throw new AdditionServiceException(e);
        }
    }
}
