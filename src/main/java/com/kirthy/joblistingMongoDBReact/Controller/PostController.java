package com.kirthy.joblistingMongoDBReact.Controller;

import com.kirthy.joblistingMongoDBReact.Model.Post;
import com.kirthy.joblistingMongoDBReact.Repository.PostRepository;
import com.kirthy.joblistingMongoDBReact.Repository.SearchRepository;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "https//localhost:3000")
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository searchRepo;

    @Hidden
    @GetMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(Post post){
        return repo.save(post);
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text){
        return searchRepo.findByText(text);
    }

}
