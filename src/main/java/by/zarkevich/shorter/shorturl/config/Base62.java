package by.zarkevich.shorter.shorturl.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Base62 {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(long value) {

        StringBuilder result = new StringBuilder();

        while (value > 0) {
            result.append(BASE62.charAt((int)(value % 62)));
            value /= 62;
        }

        return result.reverse().toString();
    }
}