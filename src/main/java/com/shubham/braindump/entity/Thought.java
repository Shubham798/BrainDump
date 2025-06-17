package com.shubham.braindump.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Thought {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Tag tag;

    @CreationTimestamp
    @Column(name = "created_timestamp")
    private LocalDateTime createdTimestamp;

    @Override
    public String toString() {
        return "Thought{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", tag=" + tag +
                ", createdTimestamp=" + createdTimestamp +
                '}';
    }
}
