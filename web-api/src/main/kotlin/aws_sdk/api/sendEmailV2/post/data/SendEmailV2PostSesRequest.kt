package aws_sdk.api.sendEmailV2.post.data

data class SendEmailV2PostSesRequest(
    val toAddress: String,
    val fromAddress: String,
    val subject: String,
    val body: String
)
