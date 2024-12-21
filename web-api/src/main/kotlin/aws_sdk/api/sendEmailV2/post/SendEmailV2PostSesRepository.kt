package aws_sdk.api.sendEmailV2.post

import aws_sdk.api.sendEmailV2.post.data.SendEmailV2PostRequest

interface SendEmailV2PostSesRepository {
  fun sendEmailV2(sesV2Request: SendEmailV2PostRequest)
}
