package com.posts.apidevelopment3party_posts.Models;

public class Post extends BaseModel{

    private String title;
    private String body;
    private String[] tags;
    private Reactions reactions;
    private Long views;
    private Long userId;

    public Post() {
    }

    public Post(String title, String body, String[] tags, Reactions reactions, Long views, Long userId) {
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.reactions = reactions;
        this.views = views;
        this.userId = userId;
    }

    public Post(Long id, String title, String body, String[] tags, Reactions reactions, Long views, Long userId) {
        super(id);
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.reactions = reactions;
        this.views = views;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Reactions getReactions() {
        return reactions;
    }

    public void setReactions(Reactions reactions) {
        this.reactions = reactions;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
