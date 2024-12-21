# LocalStack

## LocalStack について

localstack とは AWS の CLI ベースのエミュレータです。\
docker を用いて localstack を起動することで local 環境で AWS のサービスを利用したアプリケーションを動作確認することができる。

## localstack 配下について

localstack ディレクトリ配下には localstack を用いて AWS サービスを起動させるためのスクリプトファイルを格納している。

## awscli-local の環境構築

localstack は docker で起動する。
localstack を起動してからは awscli-local を用いて操作を行う。
awslocal-cli の環境構築は以下の通り。

1\. awscli をインストール

```
$ pip install awscli
```

2\. awscli-local をインストール

```
$ pip install awscli-local
```

3\. awscli, awscli-local がインストールされていることを確認

```
$ pip list | grep awscli
```

4\. ~/aws/config を設定

```
$ awslocal configure
AWS Access Key ID [None]: dummy
AWS Secret Access Key [None]: dummy
Default region name [None]: ap-northeast-1
Default output format [None]:
```
