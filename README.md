# 単純すぎるドメイン駆動設計サンプルコード(Java)

ごく単純な足し算アプリを、手続き型設計とドメイン駆動設計を対比して記述したサンプルコード(Java)です。

## setup
```sh
$ gradle clean build
```

## sample1
- ドメインの隔離
- 値オブジェクト
```sh
# 手続き型設計コードの実行例
$ java -cp build/libs/learn-ddd-1.0-SNAPSHOT.jar com.example.ddd.learn.sample01.transaction.TransactionAddition01 1 1
1 + 1 = 2

# ドメイン駆動設計コードの実行例
$ java -cp build/libs/learn-ddd-1.0-SNAPSHOT.jar com.example.ddd.learn.sample01.ddd.DDDAddition01 1 1
1 + 1 = 2
```

## sample2
- 値オブジェクトの事前条件を追加
```sh
# 手続き型設計コードの実行例
$ java -cp build/libs/learn-ddd-1.0-SNAPSHOT.jar com.example.ddd.learn.sample02.transaction.TransactionAddition02 1 1
1 + 1 = 2

# ドメイン駆動設計コードの実行例
$ java -cp build/libs/learn-ddd-1.0-SNAPSHOT.jar com.example.ddd.learn.sample02.ddd.DDDAddition02 1 1
1 + 1 = 2
```

## sample3
- エンティティ
- リポジトリ
```sh
# 手続き型設計コードの実行例
$ java -cp build/libs/learn-ddd-1.0-SNAPSHOT.jar com.example.ddd.learn.sample03.transaction.TransactionAddition03
'username 1 2'のように入力すると、username.csvに'1,2,3'(1つ目の値,2つ目の値,足し算結果)と出力します
'q'を入力すると終了します
hoge 1 1
1 + 1 = 2
fuga 2 3
2 + 3 = 5
q
終了します

# ドメイン駆動設計コードの実行例
$ java -cp build/libs/learn-ddd-1.0-SNAPSHOT.jar com.example.ddd.learn.sample03.ddd.DDDAddition03
'username 1 2'のように入力すると、username.csvに'1,2,3'(1つ目の値,2つ目の値,足し算結果)と出力します
'q'を入力すると終了します
hoge 1 1
1 + 1 = 2
fuga 2 3
2 + 3 = 5
q
終了します
```

## test
```sh
$ gradle test
```
