package org.killreal777.pastebin.apiservice.service;

import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;

@Service
public class LongHashServiceBase64Impl implements LongHashService {

    @Override
    public String encode(Long value) {
        return Base64.getUrlEncoder().encodeToString(longToBytes(value));
    }

    private byte[] longToBytes(long value) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(value);
        return buffer.array();
    }

    @Override
    public Long decode(String value) {
        return bytesToLong(Base64.getUrlDecoder().decode(value));
    }

    public long bytesToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return buffer.getLong();
    }

}
