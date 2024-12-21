#!/bin/sh

awslocal ses verify-email-identity \
  --email-address sender@example.com \
  --region "ap-northeast-1" \
  --endpoint-url http://localhost:4566

awslocal ses list-identities \
  --identity-type EmailAddress \
  --region "ap-northeast-1" \
  --endpoint-url http://localhost:4566
