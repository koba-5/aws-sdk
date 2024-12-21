package aws_sdk.api.sendEmail.post.data

import com.fasterxml.jackson.annotation.JsonProperty

data class SendEmailPostRequest(
    @JsonProperty("to_address") val toAddress: String,
    @JsonProperty("from_address") val fromAddress: String,
    @JsonProperty("subject") val subject: String,
    @JsonProperty("body") val body: String
)
