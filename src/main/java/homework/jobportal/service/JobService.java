package homework.jobportal.service;

import homework.jobportal.dto.JobDto;
import homework.jobportal.dto.SearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface JobService {
Page<JobDto> getAll(Pageable pageable, SearchDto searchDto);
JobDto getJobDetails(String id);
}
