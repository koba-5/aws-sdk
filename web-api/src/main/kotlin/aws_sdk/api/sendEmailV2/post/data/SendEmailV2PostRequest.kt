package aws_sdk.api.sendEmailV2.post.data

import com.fasterxml.jackson.annotation.JsonProperty

data class SendEmailV2PostRequest(
    @JsonProperty("to_address") val toAddress: String,
    @JsonProperty("from_address") val fromAddress: String,
    @JsonProperty("subject") val subject: String,
    @JsonProperty("body") val body: String
)
