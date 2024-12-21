package aws_sdk.messages.show_text

import aws_sdk.messages.show_text.data.ShowTextSqsMessage
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ShowTextService(private val objectMapper: ObjectMapper) {
  companion object {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
  }

  fun execute(messages: List<ShowTextSqsMessage>) {
    messages.forEachIndexed { index, message ->
      val messageStr = objectMapper.writeValueAsString(message)
      LOGGER.info("No.$index: ${messageStr.trimIndent()}")
    }
  }
}
