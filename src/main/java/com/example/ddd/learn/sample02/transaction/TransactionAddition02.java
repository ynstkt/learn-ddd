package com.example.ddd.learn.sample02.transaction;

public class TransactionAddition02 {

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
        // チェック処理を追加
        if (param1 < 0 || param2 < 0) {
            System.err.println("負の数は扱いません");
            System.exit(1);
        }

        // 足し算を実行
        int result = param1 + param2;

        // 結果を表示
        System.out.printf("%s + %s = %s%n", param1, param2, result);
    }
}
