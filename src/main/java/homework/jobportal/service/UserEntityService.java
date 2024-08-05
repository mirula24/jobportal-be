package homework.jobportal.service;

import homework.jobportal.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface UserEntityService {
    UserDto getUserProfile(Long userId);
    UserDto updateUserProfile(Long userId, UserDto userDto);
    Page<UserDto> getAllUsers(Pageable pageable,UserDto userDto);
    Long getUserIdByUsername(String username);
}
