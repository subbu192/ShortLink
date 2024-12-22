package com.manchala.shortlink.controller;

import com.manchala.shortlink.dto.URLBean;
import com.manchala.shortlink.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class URLController {
    @Autowired
    private URLService urlService;

    @RequestMapping(
            value = "generate",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> getShortUrl(@RequestBody URLBean longUrlBean) {
        URLBean shortUrlBean = urlService.getShortUrl(longUrlBean);
        return new ResponseEntity<>(shortUrlBean.getShortUrl(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "{shortUrl}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Object> redirectToLongUrl(@PathVariable String shortUrl) throws URISyntaxException {
        URLBean longUrlBean = urlService.getLongUrl(shortUrl);
        URI longUrl = new URI(longUrlBean.getLongUrl());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(longUrl);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @RequestMapping(
            value = "getall",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<URLBean>> getAllUrls() {
        List<URLBean> urlBeanList = urlService.getAllUrls();
        return new ResponseEntity<>(urlBeanList, HttpStatus.OK);
    }
}
