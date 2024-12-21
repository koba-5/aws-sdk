package aws_sdk.api.sendEmail.post

import aws_sdk.api.sendEmail.post.data.SendEmailPostSesRequest
import java.net.URI
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.ses.SesClient
import software.amazon.awssdk.services.ses.model.*

@Repository
@ConditionalOnProperty(prefix = "env.aws.ses", name = ["mock-level"], havingValue = "localstack")
class SendEmailPostSesRepositoryImpl(
    @Value("\${env.aws.region}") private val region: String,
    @Value("\${env.aws.access-key-id}") private val accessKeyId: String,
    @Value("\${env.aws.secret-access-key}") private val secretAccessKey: String,
    @Value("\${env.aws.endpoint}") private val endpoint: String,
) : SendEmailPostSesRepository {
  private val sesClient =
      SesClient.builder()
          .credentialsProvider(
              StaticCredentialsProvider.create(
                  AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
          .region(Region.of(region))
          .endpointOverride(URI.create(endpoint))
          .build()

  override fun sendEmail(sesRequest: SendEmailPostSesRequest) {
    val destination = Destination.builder().toAddresses(sesRequest.toAddress).build()
    val message =
        Message.builder()
            .subject(Content.builder().data(sesRequest.subject).build())
            .body(Body.builder().text(Content.builder().data(sesRequest.body).build()).build())
            .build()
    val sendEmailRequest =
        SendEmailRequest.builder()
            .destination(destination)
            .source(sesRequest.fromAddress)
            .message(message)
            .build()

    sesClient.sendEmail(sendEmailRequest)
  }
}
