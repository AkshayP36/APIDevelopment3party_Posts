package com.posts.apidevelopment3party_posts.Services;

import com.posts.apidevelopment3party_posts.Error.PostNotFoundException;
import com.posts.apidevelopment3party_posts.Models.Post;
import com.posts.apidevelopment3party_posts.Models.Reactions;

public interface PostService {
    Post getAPost(Long id) throws PostNotFoundException;
    Post[] getAllPosts() throws PostNotFoundException;
    Post createAPost(Long id, String title, String body, String[] tags, Reactions reactions, Long views, Long userid);
    Post updateAPost(Long id, String title, String body, String[] tags, Reactions reactions, Long views, Long userid);
    Post deleteAPost(Long id) throws PostNotFoundException;
}
