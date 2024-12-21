package aws_sdk.api.sendEmail.post

import aws_sdk.api.sendEmail.post.data.SendEmailPostSesRequest

interface SendEmailPostSesRepository {
  fun sendEmail(sesRequest: SendEmailPostSesRequest)
}
