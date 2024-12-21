package aws_sdk.api.submitText.post

import aws_sdk.api.submitText.post.data.SubmitTextPostRequest
import aws_sdk.api.submitText.post.data.SubmitTextPostSqsMessage
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class SubmitTextPostService(
    private val objectMapper: ObjectMapper,
    private val sqsRepository: SubmitTextPostRepository
) {

  fun execute(request: SubmitTextPostRequest) {
    val sqsMessage = SubmitTextPostSqsMessage(submitId = request.submitId, text = request.text)
    val sqsMessageStr = objectMapper.writeValueAsString(sqsMessage)

    sqsRepository.sendMessage(submitId = request.submitId, sqsMessage = sqsMessageStr)
  }
}
