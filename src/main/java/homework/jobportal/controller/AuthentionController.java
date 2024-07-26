package homework.jobportal.controller;
import homework.jobportal.service.UserEntityService;
import homework.jobportal.util.dto.AuthDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthentionController {
    private final UserEntityService userEntityService;

    @PostMapping("/register")
    public ResponseEntity<?> create (@Valid @RequestBody AuthDto request){
        userEntityService.create(request);
        return ResponseEntity.ok("User Success Register");
    }

}
