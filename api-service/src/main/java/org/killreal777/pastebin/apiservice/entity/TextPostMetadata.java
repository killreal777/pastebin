package org.killreal777.pastebin.apiservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class TextPostMetadata {

    @Id
    @GeneratedValue
    private Long id;

}
