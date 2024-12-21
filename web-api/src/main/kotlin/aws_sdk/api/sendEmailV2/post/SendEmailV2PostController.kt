package aws_sdk.api.sendEmailV2.post

import aws_sdk.api.sendEmailV2.post.data.SendEmailV2PostRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SendEmailV2PostController(private val service: SendEmailV2PostService) {

  @PostMapping("/api/send_email_v2")
  fun sendEmailV2Post(@RequestBody request: SendEmailV2PostRequest) {
    service.execute(request = request)
  }
}
