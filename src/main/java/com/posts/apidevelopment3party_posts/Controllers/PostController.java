package com.posts.apidevelopment3party_posts.Controllers;

import com.posts.apidevelopment3party_posts.Error.PostNotFoundException;
import com.posts.apidevelopment3party_posts.Models.Post;
import com.posts.apidevelopment3party_posts.Services.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private PostService postService;

    public PostController(@Qualifier("DummyJSONPostService") PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{id}")
    public Post getAPost(@PathVariable("id") Long id) throws PostNotFoundException{
        return postService.getAPost(id);
    }

    @GetMapping("/post")
    public Post[] getAllPosts() throws PostNotFoundException{
        return postService.getAllPosts();
    }

    @PostMapping("/post")
    public Post createAPost(@RequestBody Post post){
        return postService.createAPost(post.getId(), post.getTitle(), post.getBody(), post.getTags(),
                post.getReactions(), post.getViews(), post.getUserId());
    }
    @PutMapping("/post/{id}")
    public Post updateAPost(@PathVariable("id") Long id, @RequestBody Post post){
        return postService.updateAPost(id, post.getTitle(), post.getBody(), post.getTags(),
                post.getReactions(), post.getViews(), post.getUserId());
    }
    @DeleteMapping("/post/{id}")
    public Post deleteAPost(@PathVariable("id") Long id) throws PostNotFoundException{
        return postService.deleteAPost(id);
    }
}
