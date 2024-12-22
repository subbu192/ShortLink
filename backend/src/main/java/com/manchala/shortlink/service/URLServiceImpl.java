package com.manchala.shortlink.service;

import com.manchala.shortlink.dao.URLDaoWrapper;
import com.manchala.shortlink.dto.URLBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class URLServiceImpl implements URLService {
    @Autowired
    private URLDaoWrapper urlDaoWrapper;

    @Override
    public URLBean getShortUrl(URLBean longUrlBean) {
        return urlDaoWrapper.getShortUrl(longUrlBean);
    }

    @Override
    public URLBean getLongUrl(URLBean shortUrlBean) {
        return urlDaoWrapper.getLongUrl(shortUrlBean);
    }

    @Override
    public List<URLBean> getAllUrls() {
        return urlDaoWrapper.getAllUrls();
    }
}
