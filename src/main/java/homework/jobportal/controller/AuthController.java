package homework.jobportal.controller;

import homework.jobportal.dto.LoginRequest;
import homework.jobportal.dto.RegisterRequest;
import homework.jobportal.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Value("${header.secretkey}")
    private String secretkey;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(
            @RequestHeader("Authorization") String refreshToken
    ) {
        return ResponseEntity.ok(authService.refreshToken(refreshToken));
    }

    @PostMapping("/register-super-admin")
    public ResponseEntity<?> createSuperAdmin(@RequestHeader("X-Super-Admin-Secret-Key")
                                                  String secret,@RequestBody RegisterRequest request){

        try{
            if(secret.equals(secretkey)){
                return new ResponseEntity<>(authService.createsuperAdmin(request), HttpStatus.CREATED);
            }else{
                throw new BadCredentialsException("secret key is wrong");
            }
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
