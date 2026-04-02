package by.zarkevich.shorter.shorturl.controller;

import by.zarkevich.shorter.shorturl.dto.request.UrlDTORequest;
import by.zarkevich.shorter.shorturl.dto.response.UrlDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface RedirectController {
    ResponseEntity<Void> redirect(@PathVariable String shortCode);

    ResponseEntity<UrlDTOResponse> registerUrl(@RequestBody UrlDTORequest urlDTO);
}
