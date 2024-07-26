package homework.jobportal.service.implementation;

import homework.jobportal.model.UserEntity;
import homework.jobportal.repository.UserRepository;
import homework.jobportal.service.UserEntityService;
import homework.jobportal.util.dto.AuthDto;
import homework.jobportal.util.specification.GeneralSpecification;
import homework.jobportal.util.specification.UserSpecification;
import homework.jobportal.util.validator.PasswordValidator;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserEntityImpl implements UserEntityService {
    private final UserRepository userRepository;

    @Override
    public UserEntity create(AuthDto request) {
        String username = request.getUsername();
        List<UserEntity> users = userRepository.findAll();
        for (var v : users) {
            if(v.getUsername().equals(request.getUsername())){
                {
                    throw new RuntimeException("User already Register");
                }
                }
            }
        if (request.getPassword().length() < 8){
            throw new RuntimeException("Password minimal 8 chacraters");
        }
        boolean isValidPassword = PasswordValidator.passwordValidator(request.getPassword());
        if(!isValidPassword){
            throw new RuntimeException("Your password must be contains alphabet lowercase , uppercase and number");
        }


    UserEntity user = UserEntity.builder()
            .username(request.getUsername())
            .password(request.getPassword())
            .build();
        return userRepository.save(user);
    }

    @Override
    public Page<UserEntity> getAll(String username, Pageable pageable) {
        Specification<UserEntity> spec = UserSpecification.getSpecification(username);
        return userRepository.findAll(spec, pageable);
    }

    @Override
    public UserEntity getOne(Long id) {
        UserEntity getOne = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
        return getOne;
    }

    @Override
    public UserEntity update(Long id, AuthDto request) {
        UserEntity update = getOne(id);
        update.setUsername(request.getUsername());
        return userRepository.save(update);
    }

    @Override
    public void delete(Long id) {
        UserEntity delete = getOne(id);
        userRepository.delete(delete);

    }
}
