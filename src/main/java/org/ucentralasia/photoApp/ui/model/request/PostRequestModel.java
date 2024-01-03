package org.ucentralasia.photoApp.ui.model.request;

import org.ucentralasia.photoApp.shared.dto.UserDto;

public class PostRequestModel {
    private String userId;
    private String title;
    private String content;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
