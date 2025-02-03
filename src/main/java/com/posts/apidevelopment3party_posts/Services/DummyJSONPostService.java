package com.posts.apidevelopment3party_posts.Services;

import com.posts.apidevelopment3party_posts.Error.PostNotFoundException;
import com.posts.apidevelopment3party_posts.Models.Post;
import com.posts.apidevelopment3party_posts.Models.Reactions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service("DummyJSONPostService")
public class DummyJSONPostService implements PostService{

    private RestTemplate restTemplate;

    public DummyJSONPostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Post getAPost(Long id) throws PostNotFoundException {
        Post post = restTemplate.getForObject("https://dummyjson.com/posts/"+id, Post.class);
        return post;
    }

    @Override
    public Post[] getAllPosts() throws PostNotFoundException {
//        List<Post> postlist = restTemplate.getForObject("https://dummyjson.com/posts", Post.class);
//        return postlist;
        ResponseEntity<List<Post>> response = restTemplate.exchange(
                "https://dummyjson.com/posts", HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {});

        List<Post> postList = response.getBody();

        if (postList == null || postList.isEmpty()) {
            throw new PostNotFoundException("No posts found");
        }

        // Convert List<Post> to Post[] and return it
        return postList.toArray(new Post[0]);
    }

    @Override
    public Post createAPost(Long id, String title, String body,
                            String[] tags, Reactions reactions, Long views, Long userid) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setBody(body);
        post.setTags(tags);
        post.setReactions(reactions);
        post.setViews(views);
        post.setUserId(userid);
        restTemplate.postForObject("https://dummyjson.com/posts/add", post, Post.class);
        return post;
    }

    @Override
    public Post updateAPost(Long id, String title, String body, String[] tags, Reactions reactions, Long views, Long userid) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setBody(body);
        post.setTags(tags);
        post.setReactions(reactions);
        post.setViews(views);
        post.setUserId(userid);

        // Make sure to use PUT for updating a resource
        ResponseEntity<Post> response = restTemplate.exchange("https://dummyjson.com/posts/" + id, HttpMethod.PUT, new HttpEntity<>(post), Post.class);

        // Check if the update was successful
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody(); // Return the updated post
        } else {
            // Handle the failure case, maybe throw an exception or log
            throw new RuntimeException("Failed to update post");
        }
    }

    @Override
    public Post deleteAPost(Long id) throws PostNotFoundException {
        Post post = restTemplate.getForObject("https://dummyjson.com/posts/"+id, Post.class);
        restTemplate.delete("https://dummyjson.com/posts/"+id, Post.class);
        return post;
    }
}
