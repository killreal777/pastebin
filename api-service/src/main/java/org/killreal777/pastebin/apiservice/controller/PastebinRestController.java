package org.killreal777.pastebin.apiservice.controller;

import lombok.RequiredArgsConstructor;
import org.killreal777.pastebin.apiservice.dto.TextPostDto;
import org.killreal777.pastebin.apiservice.service.TextPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PastebinRestController {
    private final TextPostService textPostService;

    @PostMapping
    public ResponseEntity<TextPostDto> post(@RequestParam("text") String text) {
        return ResponseEntity.ok(textPostService.createTextPost(new TextPostDto(text)));
    }

    @GetMapping("/{hashId}")
    public ResponseEntity<TextPostDto> get(@PathVariable("hashId") String hashId) {
        return ResponseEntity.ok(textPostService.getTextPost(hashId));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam("hashId") String hashId) {
        textPostService.deleteTextPost(hashId);
        return ResponseEntity.ok().build();
    }
}
