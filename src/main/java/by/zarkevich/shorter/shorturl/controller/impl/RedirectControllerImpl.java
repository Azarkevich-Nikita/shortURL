package by.zarkevich.shorter.shorturl.controller.impl;

import by.zarkevich.shorter.shorturl.controller.RedirectController;
import by.zarkevich.shorter.shorturl.entity.Urls;
import by.zarkevich.shorter.shorturl.service.impl.UrlsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class RedirectControllerImpl implements RedirectController {
    private final UrlsServiceImpl urlsService;

    public RedirectControllerImpl(UrlsServiceImpl urlsService) {
        this.urlsService = urlsService;
    }

    @Override
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getAll(@PathVariable String shortCode) {

        log.info("getAll was called with shortCode {" + shortCode + "}");
        String fullUrl =  urlsService.getFullURL(shortCode);

        return ResponseEntity
                .status(302)
                .location(URI.create(fullUrl))
                .build();
    }
}