package homework.jobportal.service;

import homework.jobportal.model.UserEntity;
import homework.jobportal.util.dto.AuthDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserEntityService {
    UserEntity create(AuthDto request);
    Page<UserEntity> getAll(String username, Pageable pageable);
    UserEntity getOne(Long id);
    UserEntity update(Long id, AuthDto request);
    void delete(Long id);
}
