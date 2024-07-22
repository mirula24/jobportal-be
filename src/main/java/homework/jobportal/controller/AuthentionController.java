package homework.jobportal.controller;
import homework.jobportal.service.UserEntityService;
import homework.jobportal.util.dto.AuthDto;
import homework.jobportal.util.response.PageResponse;
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
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthentionController {
    private final UserEntityService userEntityService;

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody AuthDto request){
        userEntityService.create(request);
        return ResponseEntity.ok("User Success Register");
    }

    @GetMapping
    public ResponseEntity<?> getAll( @PageableDefault Pageable pageable,
                                    @RequestParam(required = false) String name){
        return Response.renderJSON(new PageResponse<>(userEntityService.getAll(name,pageable)));

    }
}
