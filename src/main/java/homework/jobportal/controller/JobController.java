package homework.jobportal.controller;

import homework.jobportal.dto.SearchDto;
import homework.jobportal.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
@Validated
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<?> getAllJobs(
            @PageableDefault(size = 10) Pageable pageable,
            @ModelAttribute SearchDto searchDto) {
        return new ResponseEntity<>(jobService.getAll(pageable, searchDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getJobDetails(@PathVariable String id){
        return new ResponseEntity(jobService.getJobDetails(id),HttpStatus.OK);
    }
}