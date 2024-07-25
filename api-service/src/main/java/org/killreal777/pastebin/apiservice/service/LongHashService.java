package org.killreal777.pastebin.apiservice.service;

import org.springframework.stereotype.Service;

@Service
public interface LongHashService {

    String encode(Long value);

    Long decode(String value);

}
