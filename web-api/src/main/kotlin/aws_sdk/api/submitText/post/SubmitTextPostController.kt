package aws_sdk.api.submitText.post

import aws_sdk.api.submitText.post.data.SubmitTextPostRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SubmitTextPostController(private val service: SubmitTextPostService) {

  @PostMapping("/api/submit_text")
  fun submitTextPost(@RequestBody request: SubmitTextPostRequest) {
    service.execute(request = request)
  }
}
