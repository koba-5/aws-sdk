package aws_sdk.api.sendEmail.post

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class SendEmailPostControllerTest {
  companion object {
    private const val endPoint = "/api/send_email"
  }

  @Autowired private lateinit var mockMvc: MockMvc

  @Test
  fun sendEmailPost() {
    // given
    val request =
        """
          {
            "from_address": "sender@example.com",
            "to_address": "recipient@example.com",
            "subject": "[テスト] Amazon SES",
            "body": "メール送信"
          }
      """
            .trimIndent()

    // when & then
    mockMvc
        .perform(
            MockMvcRequestBuilders.post(endPoint)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andReturn()
  }
}
