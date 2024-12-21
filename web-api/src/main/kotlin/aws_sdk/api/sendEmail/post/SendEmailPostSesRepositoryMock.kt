package aws_sdk.api.sendEmail.post

import aws_sdk.api.sendEmail.post.data.SendEmailPostSesRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository
import software.amazon.awssdk.services.ses.model.*

@Repository
@ConditionalOnProperty(prefix = "env.aws.ses", name = ["mock-level"], havingValue = "mock")
class SendEmailPostSesRepositoryMock(private val objectMapper: ObjectMapper) :
    SendEmailPostSesRepository {
  companion object {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
  }

  override fun sendEmail(sesRequest: SendEmailPostSesRequest) {
    val sesRequestString = objectMapper.writeValueAsString(sesRequest)
    LOGGER.info("mock: $sesRequestString")
  }
}
