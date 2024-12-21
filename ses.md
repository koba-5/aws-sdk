# Amazon SES（Simple Email Service）

## SES について

- SQS は AWS が提供するクラウド型のメール送信サービス

## 要点

## cli コマンド

送信元メールアドレスの認証

```
awslocal ses verify-email-identity \
  --email-address sender@example.com
```

検証済みのメールアドレスを取得

```
awslocal ses list-identities
```

メール送信

```
awslocal ses send-email \
  --region ap-northeast-1 \
  --to recipient@example.com \
  --from sender@example.com \
  --cc xxx@example.com \
  --subject 'cc only test mail' \
  --text 'test message.'
```

## 参考

- https://docs.aws.amazon.com/cli/latest/reference/ses/#cli-aws-ses
