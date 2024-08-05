package homework.jobportal.service.Implement;

import homework.jobportal.dto.UserDto;
import homework.jobportal.exception.ResourceNotFoundException;
import homework.jobportal.model.UserEntity;
import homework.jobportal.repository.UserEntityRepository;
import homework.jobportal.service.UserEntityService;
import homework.jobportal.util.specification.GeneralSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {
    private final UserEntityRepository userEntityRepository;

    @Override
    public UserDto getUserProfile(Long userId) {
        UserEntity getOne = userEntityRepository.getReferenceById(userId);
        return new UserDto(getOne);
    }

    @Override
    public UserDto updateUserProfile(Long userId, UserDto userDto) {
        UserEntity updateUser = userEntityRepository.getReferenceById(userId);
        updateUser.setRole(UserEntity.Role.valueOf(userDto.getRole()));
        updateUser.setPassword(userDto.getUsername());
        return new UserDto(updateUser);
    }

    @Override
    public Page<UserDto> getAllUsers(Pageable pageable, UserDto userDto) {
        Specification<UserEntity> specification = GeneralSpecification.getSpecification(userDto);
        Page<UserEntity> users = userEntityRepository.findAll(specification, pageable);
        return users.map(UserDto::new);
    }

    @Override
    public Long getUserIdByUsername(String username) {
        UserEntity userEntity = userEntityRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with username: " + username));
        return userEntity.getId();
    }
}
