package org.killreal777.pastebin.apiservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.killreal777.pastebin.apiservice.dto.TextPostDto;
import org.killreal777.pastebin.apiservice.entity.TextPostMetadata;
import org.killreal777.pastebin.apiservice.repository.TextPostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TextPostServiceImpl implements TextPostService {
    private final TextPostRepository textPostRepository;
    private final LongHashService longHashService;
    private final TextStorageService textStorageService;

    @Override
    @Transactional
    public TextPostDto createTextPost(TextPostDto textPostDto) {
        TextPostMetadata textPostMetadata = textPostRepository.save(new TextPostMetadata());
        textPostDto.setHashId(longHashService.encode(textPostMetadata.getId()));
        textStorageService.upload(textPostDto.getHashId(), textPostDto.getContent());
        return textPostDto;
    }

    @Override
    public TextPostDto getTextPost(String hashId) {
        return TextPostDto.builder()
                .hashId(hashId)
                .content(textStorageService.download(hashId))
                .build();
    }

    @Override
    @Transactional
    public void deleteTextPost(String hashId) {
        textStorageService.delete(hashId);
        textPostRepository.deleteById(longHashService.decode(hashId));
    }
}
