#!/bin/sh

awslocal sqs create-queue \
  --queue-name test-queue.fifo \
  --attributes "FifoQueue"=True \
  --region "ap-northeast-1" \
  --endpoint-url http://localhost:4566
