package aws_sdk.api.sendEmailV2.post

import aws_sdk.api.sendEmailV2.post.data.SendEmailV2PostRequest
import java.net.URI
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sesv2.SesV2Client
import software.amazon.awssdk.services.sesv2.model.*

@Repository
@ConditionalOnProperty(
    prefix = "env.aws.ses-v2", name = ["mock-level"], havingValue = "ses-v2-local")
class SendEmailV2PostSesRepositoryImpl(
    @Value("\${env.aws.region}") private val region: String,
    @Value("\${env.aws.access-key-id}") private val accessKeyId: String,
    @Value("\${env.aws.secret-access-key}") private val secretAccessKey: String,
    @Value("\${env.aws.ses-v2.endpoint}") private val endpoint: String,
) : SendEmailV2PostSesRepository {
  private val sesV2Client =
      SesV2Client.builder()
          .credentialsProvider(
              StaticCredentialsProvider.create(
                  AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
          .region(Region.of(region))
          .endpointOverride(URI.create(endpoint))
          .build()

  override fun sendEmailV2(sesV2Request: SendEmailV2PostRequest) {
    val destination = Destination.builder().toAddresses(sesV2Request.toAddress).build()
    val message =
        Message.builder()
            .subject(Content.builder().data(sesV2Request.subject).build())
            .body(Body.builder().text(Content.builder().data(sesV2Request.body).build()).build())
            .build()
    val emailContent = EmailContent.builder().simple(message).build()
    val sendEmailRequest =
        SendEmailRequest.builder()
            .destination(destination)
            .fromEmailAddress(sesV2Request.fromAddress)
            .content(emailContent)
            .build()

    sesV2Client.sendEmail(sendEmailRequest)
  }
}
