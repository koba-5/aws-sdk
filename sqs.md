# Amazon SQS（Simple Queue Service）

## SQS について

- SQS は AWS が提供するメッセージキューイングサービス
- メッセージキューイングサービスとは、アプリケーション間でメッセージをやり取りする仕組みのことで、メッセージは一時的にキューと呼ばれる場所に格納される。
- Amazon SQS を用いることで、プロデューサーがメッセージを作成･送信し､コンシューマがメッセージを受信･処理するといった仕組みを実現できる簡単に実現できる。

## 要点

### キューは標準キューと FIFO キューの 2 種類が存在する

#### 標準キュー

- スループットは無制限
- 配信順序はベストエフォートで保証されない
  - 順番が前後する可能性がある
- メッセージは最低 1 回配信される
  - 複数回配信される可能性がある

#### FIFO キュー

- スループットは制限あり
  - 1 秒あたり 300 件のメールを処理
- 配信順序は保証される
- メッセージは必ず 1 回のみ配信される

### 可視性タイムアウト

- 可視性タイムアウト期間とは他のコンシューマから見えなくなる期間のことです。
- メッセージは可視性タイムアウト内に処理させる必要があります。
- 可視性タイムアウト内に処理されないとメッセージが並列で処理されてしまいます。

### デッドレターキュー

- デッドレターキューとはメッセージが何度も失敗した場合に別のキューに移動させる機能です。
- デッドレターキューに移動したメッセージは後で調査や再処理ができる。

### バッチ処理

- バッチ処理とは複数のメッセージを送受信する機能です。
- バッチ処理を使うとレイテンシーやオーバーヘッドを減らし、スループットを向上させることができる。

### メッセージ属性

- メッセージ属性とはメッセージに付与するメタデータです。
- メッセージ属性を用いると、コンシューマが処理方法を判断することができる。

## cli コマンド

sqs 作成

```
awslocal sqs create-queue \
  --queue-name test-queue.fifo \
  --region ap-northeast-1 \
  --attributes "FifoQueue"=True \
  --endpoint-url http://localhost:4566
```

sqs が作成されたことを確認

```
awslocal sqs list-queues
```

メッセージ送信

```
awslocal sqs send-message \
  --queue-url http://sqs.ap-northeast-1.localhost.localstack.cloud:4566/000000000000/test-queue.fifo \
  --message-group-id "0000000001" \
  --message-deduplication-id "eb2a9d0a-3a79-4e18-af24-5684dfe3d5f4x" \
  --message-body '{"submit_id": "0001", "message": "テストメッセージ"}'
```

sqs のメッセージ数を確認

```
awslocal sqs get-queue-attributes \
  --queue-url http://sqs.ap-northeast-1.localhost.localstack.cloud:4566/000000000000/test-queue.fifo \
  --attribute-names "ApproximateNumberOfMessages"
```

## 参考

- [Amazon SQS の特徴と機能](https://docs.aws.amazon.com/ja_jp/AWSSimpleQueueService/latest/SQSDeveloperGuide/features-capabilities.html)
- [Amazon SQS Java SDK の例](https://docs.aws.amazon.com/ja_jp/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-java-tutorials.html)
- [Amazon SQS FIFO キューキー用語](https://docs.aws.amazon.com/ja_jp/AWSSimpleQueueService/latest/SQSDeveloperGuide/FIFO-key-terms.html)
- [Amazon SQS を使用した AWS CLI の例](https://docs.aws.amazon.com/ja_jp/cli/v1/userguide/cli_sqs_code_examples.html)
