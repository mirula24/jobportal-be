package homework.jobportal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;


    @JsonProperty("url")
    private String url;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("company")
    private String company;

    @JsonProperty("company_url")
    private String company_url;

    @JsonProperty("location")
    private String location;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("company_logo")
    private String company_logo;

    @JsonProperty("how_to_apply")
    private String how_to_apply;
}
