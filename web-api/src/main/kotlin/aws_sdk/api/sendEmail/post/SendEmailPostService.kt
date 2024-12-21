package aws_sdk.api.sendEmail.post

import aws_sdk.api.sendEmail.post.data.SendEmailPostRequest
import aws_sdk.api.sendEmail.post.data.SendEmailPostSesRequest
import org.springframework.stereotype.Service

@Service
class SendEmailPostService(private val sesRepository: SendEmailPostSesRepository) {

  fun execute(request: SendEmailPostRequest) {
    val sesRequest =
        SendEmailPostSesRequest(
            toAddress = request.toAddress,
            fromAddress = request.fromAddress,
            subject = request.subject,
            body = request.body)

    sesRepository.sendEmail(sesRequest = sesRequest)
  }
}
