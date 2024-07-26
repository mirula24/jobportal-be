package homework.jobportal.controller;
import homework.jobportal.model.UserEntity;
import homework.jobportal.service.UserEntityService;
import homework.jobportal.util.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Validated
public class UserEntityController {
    private final UserEntityService userEntityService;

    @GetMapping
    public ResponseEntity<?> getAll(@Valid @PageableDefault Pageable pageable, @RequestParam(required = false) String username){
        var data =userEntityService.getAll(username,pageable);
        return Response.renderJSON(
                data,
                "This is all of users",
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@Valid @PathVariable Long id){
        userEntityService.delete(id);
        return Response.renderJSON(
            null,
                "user succes delete",
                HttpStatus.ACCEPTED
        );
    }


}
