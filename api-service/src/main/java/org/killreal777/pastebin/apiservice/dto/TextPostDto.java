package org.killreal777.pastebin.apiservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TextPostDto {

    private String hashId;

    private String content;

    public TextPostDto(String content) {
        this.content = content;
    }

}
