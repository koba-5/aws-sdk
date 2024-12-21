package aws_sdk.api.submitText.post

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
class SubmitTextPostControllerTest {
  companion object {
    private const val ENDPOINT = "/api/submit_text"
  }

  @Autowired private lateinit var mockMvc: MockMvc

  @Test
  fun submitTextPost() {
    // given
    val request = """{"submit_id": "0000000001", "text": "メッセージ"}""".trimIndent()

    // when & then
    mockMvc
        .perform(
            MockMvcRequestBuilders.post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andReturn()
  }
}
