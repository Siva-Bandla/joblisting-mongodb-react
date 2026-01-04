package com.kirthy.joblistingMongoDBReact.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "JobPost")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
}
