package org.killreal777.pastebin.apiservice.repository;

import org.killreal777.pastebin.apiservice.entity.TextPostMetadata;
import org.springframework.data.repository.CrudRepository;

public interface TextPostRepository extends CrudRepository<TextPostMetadata, Long> {
}
