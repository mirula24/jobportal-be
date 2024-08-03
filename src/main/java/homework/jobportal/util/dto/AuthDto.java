package homework.jobportal.util.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class AuthDto {
        @Data
        public static class LoginRequest {
            @NotBlank(message = "Username is required")
            private String username;

            @NotBlank(message = "Password is required")
            private String password;
        }

        @Data
        public static class RegisterRequest {
            @NotBlank(message = "Username is required")
            @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
            private String username;

            @NotBlank(message = "Password is required")
            @Size(min = 6, message = "Password must be at least 6 characters long")
            private String password;

            @NotBlank(message = "Email is required")
            @Email(message = "Invalid email format")
            private String email;

    }
}
