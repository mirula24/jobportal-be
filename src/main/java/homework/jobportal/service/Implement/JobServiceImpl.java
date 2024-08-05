package homework.jobportal.service.Implement;

import homework.jobportal.dto.JobDto;
import homework.jobportal.dto.SearchDto;
import homework.jobportal.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final RestClient restClient;
    private final String placeHolder = "https://dev6.dansmultipro.com/api/recruitment/positions.json";

    @Override
    public Page<JobDto> getAll(Pageable pageable, SearchDto searchDto) {
        List<JobDto> allJobs = fetchJobs(searchDto);

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), allJobs.size());

        List<JobDto> pageContent = allJobs.subList(start, end);

        return new PageImpl<>(pageContent, pageable, allJobs.size());
    }

    @Override
    public JobDto getJobDetails(String id) {
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("https://dev6.dansmultipro.com/api/recruitment/positions/")
                .path(id);
        return restClient.get()
                .uri(uri.toUriString())
                .retrieve()
                .body(new ParameterizedTypeReference<JobDto>() {
                });
    }

    private List<JobDto> fetchJobs(SearchDto searchDto) {
        String uri = buildUri(searchDto);

        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(new ParameterizedTypeReference<List<JobDto>>() {});
    }

    private String buildUri(SearchDto searchDto) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(placeHolder);

        if (searchDto != null) {
            builder.queryParam("full_time", searchDto.isFull_time())
                    .queryParam("location", searchDto.getLocation())
                    .queryParam("description", searchDto.getDescription());
        }

        return builder.toUriString();
    }
}