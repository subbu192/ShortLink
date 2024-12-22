package com.manchala.shortlink;

import com.manchala.shortlink.utils.URLShortener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class URLShortenerTests {

    @Test
    public void testURLShortener() {
        Long urlId = new Date().getTime();
        String shortUrl = URLShortener.convertIdToShortUrl(urlId);
        System.out.println("Converting ID to ShortURL: ");
        System.out.println(shortUrl + " - " + urlId);

        System.out.println("---------------------------");

        Long decodedUrlId = URLShortener.convertShortUrlToId(shortUrl);
        System.out.println("Converting ShortURL to ID: ");
        System.out.println(shortUrl + " - " + decodedUrlId);
        Assertions.assertEquals(urlId, decodedUrlId);
    }
}
