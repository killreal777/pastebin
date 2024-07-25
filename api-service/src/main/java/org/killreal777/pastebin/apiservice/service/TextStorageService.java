package org.killreal777.pastebin.apiservice.service;

import org.springframework.stereotype.Service;

@Service
public interface TextStorageService {

    void upload(String key, String content);

    String download(String key);

    void delete(String key);

}
