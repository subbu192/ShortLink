package com.manchala.shortlink.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "url_details")
@NoArgsConstructor
@AllArgsConstructor
public class URLEntity {

    @Id
    private Long id;
    private String title;
    @Column(name = "short_url")
    private String shortUrl;
    @Column(name = "long_url")
    private String longUrl;
    @Column(name = "click_count")
    private Integer noOfClicks = 0;
    @Column(name = "unique_clients")
    private Integer noOfUniqueClients = 0;

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

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Integer getNoOfClicks() {
        return noOfClicks;
    }

    public void setNoOfClicks(Integer noOfClicks) {
        this.noOfClicks = noOfClicks;
    }

    public Integer getNoOfUniqueClients() {
        return noOfUniqueClients;
    }

    public void setNoOfUniqueClients(Integer noOfUniqueClients) {
        this.noOfUniqueClients = noOfUniqueClients;
    }
}
