package aws_sdk.api.sendEmail.post

import aws_sdk.api.sendEmail.post.data.SendEmailPostRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SendEmailPostController(private val service: SendEmailPostService) {

  @PostMapping("/api/send_email")
  fun sendEmailPost(@RequestBody request: SendEmailPostRequest) {
    service.execute(request = request)
  }
}
