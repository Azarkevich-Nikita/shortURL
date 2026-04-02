package by.zarkevich.shorter.shorturl.controller.impl;

import by.zarkevich.shorter.shorturl.controller.RedirectController;
import by.zarkevich.shorter.shorturl.dto.request.UrlDTORequest;
import by.zarkevich.shorter.shorturl.dto.response.UrlDTOResponse;
import by.zarkevich.shorter.shorturl.service.impl.UrlsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Slf4j
public class RedirectControllerImpl implements RedirectController {
    private final UrlsServiceImpl urlsService;

    public RedirectControllerImpl(UrlsServiceImpl urlsService) {
        this.urlsService = urlsService;
    }

    @Override
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        log.info("getAll was called with shortCode {" + shortCode + "}");
        String fullUrl =  urlsService.getFullURL(shortCode);

        return ResponseEntity
                .status(302)
                .location(URI.create(fullUrl))
                .build();
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<UrlDTOResponse> registerUrl(@RequestBody UrlDTORequest request) {

        String shortCode = urlsService.createURL(request.getFullUrl());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new UrlDTOResponse(request.getFullUrl(), shortCode));
    }
}