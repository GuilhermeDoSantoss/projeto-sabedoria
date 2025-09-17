
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class ApiController {

    @GetMapping
    public ResponseEntity<com.tech.guilherme.conhecimentos.controller.aws.terraform.TimestampResponse> helloAWS() {
        return ResponseEntity.ok(new com.tech.guilherme.conhecimentos.controller.aws.terraform.TimestampResponse(Instant.now()));
    }
}
