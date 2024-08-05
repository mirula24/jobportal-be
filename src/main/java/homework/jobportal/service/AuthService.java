package homework.jobportal.service;

import homework.jobportal.dto.LoginRequest;
import homework.jobportal.dto.RegisterRequest;
import homework.jobportal.util.response.LoginResponse;
import homework.jobportal.util.response.RefreshResponse;
import homework.jobportal.util.response.RegisterResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);
    RefreshResponse refreshToken(String refreshToken);
    RegisterResponse createsuperAdmin(RegisterRequest registerRequest);
}
