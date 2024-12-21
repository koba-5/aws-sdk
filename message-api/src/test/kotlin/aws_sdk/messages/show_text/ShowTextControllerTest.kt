package aws_sdk.messages.show_text

import aws_sdk.messages.show_text.data.ShowTextSqsMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ShowTextControllerTest {
  @Autowired private lateinit var controller: ShowTextController

  @Test
  fun receiveMessage() {
    // given
    val messages =
        listOf(
            ShowTextSqsMessage(submitId = "0000000001", message = "メッセージ"),
            ShowTextSqsMessage(submitId = "0000000001", message = "メッセージ"))

    // when & then
    assertDoesNotThrow { controller.receiveMessage(messages = messages) }
  }
}
