package com.manchala.shortlink.utils;

public class URLShortener {
    private final static String mappings = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String convertIdToShortUrl(Long urlId) {
        StringBuilder shortUrl = new StringBuilder();

        while (urlId > 0) {
            int rem = (int) (urlId % 62);
            shortUrl.append(mappings.charAt(rem));
            urlId /= 62;
        }

        return shortUrl.toString();
    }
    public static Long convertShortUrlToId(String shortUrl) {
        long urlId = 0L;
        int size = shortUrl.length();
        for (int i = 0; i < size; i++) {
            char ch = shortUrl.charAt(i);
            urlId += (long) (Math.pow(62, i) * mappings.indexOf(ch));
        }
        return urlId;
    }
}