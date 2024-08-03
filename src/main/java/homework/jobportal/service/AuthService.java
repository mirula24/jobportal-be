package homework.jobportal.service;

import homework.jobportal.util.dto.AuthDto;
import homework.jobportal.util.response.LoginResponse;
import homework.jobportal.util.response.RegisterResponse;

public interface AuthService {
    LoginResponse login(AuthDto.LoginRequest loginRequest);
    RegisterResponse register(AuthDto.RegisterRequest registerRequest);
    LoginResponse refreshToken(String refreshToken);
}
