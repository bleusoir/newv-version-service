package dev.newv.version.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("languages")
public class VersionInfo {

    private String _id;
    private String name;
    private Boolean is_ga;
    private Integer version_num;
    private String update_date_text;
    private String created;
    private String updated;
}