package aws_sdk.api.submitText.post

interface SubmitTextPostRepository {

  fun sendMessage(submitId: String, sqsMessage: String)
}
