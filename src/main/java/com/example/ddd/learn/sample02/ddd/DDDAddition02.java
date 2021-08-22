package com.example.ddd.learn.sample02.ddd;

import com.example.ddd.learn.sample02.ddd.usecase.AdditionService;
import com.example.ddd.learn.sample02.ddd.usecase.AdditionServiceException;

public class DDDAddition02 {

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
            System.err.println("整数を指定してください");
            System.exit(1);
        }

        // アプリケーションサービスを生成・実行
        int result = 0;
        try {
            AdditionService service = new AdditionService();
            result = service.execute(param1, param2);
        } catch (AdditionServiceException e) {
            System.err.println("足し算サービスでエラーが発生しました");
            e.printStackTrace();
            System.exit(1);
        }

        // 結果を表示
        System.out.printf("%s + %s = %s%n", param1, param2, result);
    }
}
