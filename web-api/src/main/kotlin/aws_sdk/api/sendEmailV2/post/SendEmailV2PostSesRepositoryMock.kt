package aws_sdk.api.sendEmailV2.post

import aws_sdk.api.sendEmailV2.post.data.SendEmailV2PostRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository
import software.amazon.awssdk.services.ses.model.*

@Repository
@ConditionalOnProperty(prefix = "env.aws.ses-v2", name = ["mock-level"], havingValue = "mock")
class SendEmailV2PostSesRepositoryMock(private val objectMapper: ObjectMapper) :
    SendEmailV2PostSesRepository {
  companion object {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
  }

  override fun sendEmailV2(sesV2Request: SendEmailV2PostRequest) {
    val sesRequestString = objectMapper.writeValueAsString(sesV2Request)
    LOGGER.info("mock: $sesRequestString")
  }
}
