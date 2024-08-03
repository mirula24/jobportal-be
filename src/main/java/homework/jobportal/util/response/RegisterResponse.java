package homework.jobportal.util.response;

import homework.jobportal.model.UserEntity;
import homework.jobportal.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private Long id ;
    private String username;
    private UserRepository userRepository;

    public RegisterResponse(UserDetails userDetails){
        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        this.id= user.getId();
        this.username= user.getUsername();
    }

}
