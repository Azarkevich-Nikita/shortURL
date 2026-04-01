package by.zarkevich.shorter.shorturl.controller;

import by.zarkevich.shorter.shorturl.entity.Urls;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RedirectController {
    ResponseEntity<Void> getAll(@PathVariable String shortCode);
}
