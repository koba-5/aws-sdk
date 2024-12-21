package aws_sdk.messages.show_text

import aws_sdk.messages.show_text.data.ShowTextSqsMessage
import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class ShowTextController(private val service: ShowTextService) {

  @SqsListener(value = ["\${env.aws.sqs.test-queue-url}"], acknowledgementMode = "ON_SUCCESS")
  fun receiveMessage(messages: List<ShowTextSqsMessage>) {
    service.execute(messages = messages)
  }
}
