package aws_sdk.api.sendEmail.post.data

data class SendEmailPostSesRequest(
    val toAddress: String,
    val fromAddress: String,
    val subject: String,
    val body: String
)
