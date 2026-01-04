package com.kirthy.joblistingMongoDBReact.Repository;

import com.kirthy.joblistingMongoDBReact.Model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
