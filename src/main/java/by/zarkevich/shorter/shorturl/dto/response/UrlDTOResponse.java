package by.zarkevich.shorter.shorturl.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlDTOResponse {
    String fullERL;
    String shortCode;
}
