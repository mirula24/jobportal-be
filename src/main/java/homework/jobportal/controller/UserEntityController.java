package homework.jobportal.controller;
import homework.jobportal.dto.UserDto;
import homework.jobportal.service.UserEntityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
@Validated
public class UserEntityController {
    private final UserEntityService userEntityService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserProfile(@PathVariable Long id){
        return new ResponseEntity(userEntityService.getUserProfile(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long id,
                                               @RequestBody UserDto request){
        return new ResponseEntity(userEntityService.updateUserProfile(id,request),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(@PageableDefault Pageable pageable,
                                         @RequestBody(required = false) UserDto userDto){
        return new ResponseEntity(userEntityService.getAllUsers(pageable,userDto),HttpStatus.OK);
    }


}
