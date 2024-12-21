package aws_sdk.messages.show_text.data

import com.fasterxml.jackson.annotation.JsonProperty

data class ShowTextSqsMessage(
    @JsonProperty("submit_id") val submitId: String,
    @JsonProperty("message") val message: String
)
