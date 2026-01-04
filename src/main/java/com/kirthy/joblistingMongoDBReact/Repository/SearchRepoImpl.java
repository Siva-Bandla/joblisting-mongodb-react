package com.kirthy.joblistingMongoDBReact.Repository;

import com.kirthy.joblistingMongoDBReact.Model.Post;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
/*
 * Requires the MongoDB Java Driver.
 * https://mongodb.github.io/mongo-java-driver
 */
import java.util.Arrays;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

@Component
public class SearchRepoImpl implements SearchRepository{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts = new ArrayList<>();


        MongoDatabase database = mongoClient.getDatabase("teluskoJobPortal");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("techs", "desc", "profile"))
                        .append("matchCriteria", "any"))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));

        result.forEach(doc -> posts.add(mongoConverter.read(Post.class, doc)));
        return posts;
    }
}



