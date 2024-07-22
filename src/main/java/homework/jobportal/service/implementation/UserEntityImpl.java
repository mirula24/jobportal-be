package homework.jobportal.service.implementation;

import homework.jobportal.model.UserEntity;
import homework.jobportal.repository.UserRepository;
import homework.jobportal.service.UserEntityService;
import homework.jobportal.util.dto.AuthDto;
import homework.jobportal.util.specification.GeneralSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEntityImpl implements UserEntityService {
    private final UserRepository userRepository;

    @Override
    public UserEntity create(AuthDto request) {
    UserEntity user = UserEntity.builder()
            .username(request.getUsername())
            .password(request.getPassword())
            .build();
        return userRepository.save(user);
    }

    @Override
    public Page<UserEntity> getAll(String username, Pageable pageable) {
        Specification<UserEntity> spec = GeneralSpecification.getSpecification(username);
        return userRepository.findAll(spec, pageable);
    }

    @Override
    public UserEntity getOne(Integer id) {
        return null;
    }

    @Override
    public UserEntity update(Integer id, AuthDto request) {
        return null;
    }
}
