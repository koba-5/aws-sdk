package aws_sdk.api.submitText.post

import java.net.URI
import java.util.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model.SendMessageRequest

@Repository
@ConditionalOnProperty(prefix = "env.aws.sqs", name = ["mock-level"], havingValue = "localstack")
class SubmitTextPostRepositoryImpl(
    @Value("\${env.aws.region}") private val region: String,
    @Value("\${env.aws.access-key-id}") private val accessKeyId: String,
    @Value("\${env.aws.secret-access-key}") private val secretAccessKey: String,
    @Value("\${env.aws.endpoint}") private val endpoint: String,
    @Value("\${env.aws.sqs.test-queue-url}") private val queueUrl: String
) : SubmitTextPostRepository {
  private val sqsClient =
      SqsClient.builder()
          .credentialsProvider(
              StaticCredentialsProvider.create(
                  AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
          .region(Region.of(region))
          .endpointOverride(URI.create(endpoint))
          .build()

  override fun sendMessage(submitId: String, sqsMessage: String) {
    val messageDeduplicationId = UUID.randomUUID().toString()
    val sqsRequest =
        SendMessageRequest.builder()
            .queueUrl(queueUrl)
            .messageGroupId(submitId)
            .messageDeduplicationId(messageDeduplicationId)
            .messageBody(sqsMessage)
            .build()

    sqsClient.sendMessage(sqsRequest)
  }
}
