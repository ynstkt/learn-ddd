package com.example.ddd.learn.sample01.ddd;

import com.example.ddd.learn.sample01.ddd.usecase.AdditionService;

public class DDDAddition01 {

    public static void main(String[] args) {
        // 引数チェック
        if (args.length != 2) {
            System.err.println("引数を２つ設定してください");
            System.exit(1);
        }
        int param1 = 0;
        int param2 = 0;
        try {
            param1 = Integer.parseInt(args[0]);
            param2 = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("引数には整数を指定してください");
            System.exit(1);
        }

        // アプリケーションサービスを生成・実行
        AdditionService service = new AdditionService();
        int result = service.execute(param1, param2);

        // 結果を表示
        System.out.printf("%s + %s = %s%n", param1, param2, result);
    }
}
