package homework.jobportal.util.response;

import homework.jobportal.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private Long id;
    private String username;
    private String role;

    public RegisterResponse(UserEntity user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole().toString();
    }
}
