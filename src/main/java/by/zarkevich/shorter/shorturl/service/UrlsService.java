package by.zarkevich.shorter.shorturl.service;

import by.zarkevich.shorter.shorturl.entity.Urls;
import java.util.List;

public interface UrlsService {
    String getFullURL(String shortCode);

    String createURL(String url);
}
