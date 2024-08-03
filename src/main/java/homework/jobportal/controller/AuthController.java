package homework.jobportal.controller;
import homework.jobportal.service.AuthService;
import homework.jobportal.util.dto.AuthDto;
import homework.jobportal.util.response.LoginResponse;
import homework.jobportal.util.response.RegisterResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/auth")
public class AuthController  {

    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody AuthDto.LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @Valid @RequestBody AuthDto.RegisterRequest registerRequest
    ) {
        return new ResponseEntity(authService.register(registerRequest),
                HttpStatus.CREATED);
    }


    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(
            @RequestHeader("Authorization") String refreshToken
    ) {
        return ResponseEntity.ok(authService.refreshToken(refreshToken));
    }
}


