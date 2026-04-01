package by.zarkevich.shorter.shorturl.service.impl;

import by.zarkevich.shorter.shorturl.service.UrlsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import by.zarkevich.shorter.shorturl.repository.UrlsRepository;
import by.zarkevich.shorter.shorturl.exception.shortURLException;

@Slf4j
@Service
public class UrlsServiceImpl implements UrlsService {
    private final UrlsRepository urlsRepository;

    public UrlsServiceImpl(UrlsRepository urlsRepository) {
        this.urlsRepository = urlsRepository;
    }

    @Override//TODO I need to redisign method
    public String getFullURL(String shortCode) {
        String full = "none";
        try{
            log.info("getFullURL was called with shortCode {" + shortCode + "}");
            full = urlsRepository.findByShortCode(shortCode).getFullUrl();
            if(full == null){
                throw new shortURLException("Not consist of current link");
            }
            log.info("full = " + full);
        }
        catch (shortURLException ex){
            log.error(ex.getMessage());
        }
        return full;
    }


}
