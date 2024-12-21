package aws_sdk.api.sendEmailV2.post

import aws_sdk.api.sendEmailV2.post.data.SendEmailV2PostRequest
import org.springframework.stereotype.Service

@Service
class SendEmailV2PostService(private val sesRepository: SendEmailV2PostSesRepository) {

  fun execute(request: SendEmailV2PostRequest) {
    val sesV2Request =
        SendEmailV2PostRequest(
            toAddress = request.toAddress,
            fromAddress = request.fromAddress,
            subject = request.subject,
            body = request.body)

    sesRepository.sendEmailV2(sesV2Request = sesV2Request)
  }
}
