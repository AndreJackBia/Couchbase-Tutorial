package org.smm.couchbasetutorial;

import java.io.Serializable;

/**
 * Created by Luca on 27/03/2018.
 */

class ArticleModel implements Serializable {
    private String title;
    private String link;
    private String category;
    private String description;
    private String creator;
    private String date;
    private String image;
    private String content;

    public ArticleModel(String title, String link, String category, String description, String creator, String date, String content) {
        this.title = title;
        this.link = link;
        this.category = category;
        this.description = description;
        this.creator = creator;
        this.date = date;
        this.content = content;
    }

    public ArticleModel() {}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

