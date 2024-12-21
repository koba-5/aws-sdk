package aws_sdk.api.submitText.post

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository

@Repository
@ConditionalOnProperty(prefix = "env.aws.sqs", name = ["mock-level"], havingValue = "mock")
class SubmitTextPostRepositoryMock : SubmitTextPostRepository {
  companion object {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
  }

  override fun sendMessage(submitId: String, sqsMessage: String) {
    LOGGER.info("mock: $sqsMessage")
  }
}
