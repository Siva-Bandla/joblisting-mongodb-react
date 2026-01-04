package com.kirthy.joblistingMongoDBReact.Repository;

import com.kirthy.joblistingMongoDBReact.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
