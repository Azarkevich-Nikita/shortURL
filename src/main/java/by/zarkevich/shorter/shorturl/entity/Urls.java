package by.zarkevich.shorter.shorturl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "urls")
public class Urls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long urlId;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "full_url", columnDefinition = "TEXT")
    private String fullUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
