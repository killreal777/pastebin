package org.killreal777.pastebin.apiservice.service;

import jakarta.transaction.Transactional;
import org.killreal777.pastebin.apiservice.dto.TextPostDto;
import org.springframework.stereotype.Service;

@Service
public interface TextPostService {

    @Transactional
    TextPostDto createTextPost(TextPostDto textPostDto);

    TextPostDto getTextPost(String hashId);

    @Transactional
    void deleteTextPost(String hashId);

}
