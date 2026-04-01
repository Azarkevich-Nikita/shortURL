package by.zarkevich.shorter.shorturl.repository;

import by.zarkevich.shorter.shorturl.entity.Urls;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlsRepository extends JpaRepository<Urls, Long> {
    Urls findByShortCode(String shortCode);
}
