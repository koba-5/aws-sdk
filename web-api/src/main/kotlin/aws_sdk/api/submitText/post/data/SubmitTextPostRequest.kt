package aws_sdk.api.submitText.post.data

import com.fasterxml.jackson.annotation.JsonProperty

data class SubmitTextPostRequest(
    @JsonProperty("submit_id") val submitId: String,
    @JsonProperty("text") val text: String
)
