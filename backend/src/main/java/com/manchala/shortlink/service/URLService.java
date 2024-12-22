package com.manchala.shortlink.service;

import com.manchala.shortlink.dto.URLBean;

import java.util.List;

public interface URLService {

    public URLBean getShortUrl(URLBean longUrlBean);
    public URLBean getLongUrl(URLBean shortUrlBean);
    public List<URLBean> getAllUrls();
}