package com.example.ddd.learn.sample03.transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TransactionAddition03 {

    public static void main(String[] args) {
        System.out.println("'username 1 2'のように入力すると、username.csvに'1,2,3'(1つ目の値,2つ目の値,足し算結果)と出力します");
        System.out.println("'q'を入力すると終了します");
        // 複数回実行できるように変更
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] lineArgs = sc.nextLine().split(" ");
            execute(lineArgs);
        }
    }

    private static void execute(String[] args) {
        // 終了コマンド
        if (args[0].equals("q")) {
            System.out.println("終了します");
            System.exit(0);
        }
        // 引数チェック
        if (args.length != 3) {
            System.err.println("引数を3つ指定してください");
            System.exit(1);
        }
        // 引数にユーザ名を追加
        String username = args[0];
        int param1 = 0;
        int param2 = 0;
        try {
            param1 = Integer.parseInt(args[1]);
            param2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("整数を指定してください");
            System.exit(1);
        }
        if (param1 < 0 || param2 < 0) {
            System.err.println("負の数は扱いません");
            System.exit(1);
        }

        // 足し算を実行
        int result = param1 + param2;

        // 履歴をファイル出力
        String filename = username + ".csv";
        try(FileWriter fw = new FileWriter(filename, true)) {
            fw.write(String.format("%s,%s,%s%n", param1, param2, result));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        // 結果を表示
        System.out.printf("%s + %s = %s%n", param1, param2, result);
    }
}
