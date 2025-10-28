package ru.omsu.fctk.Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Getter
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String text;

    @Column(nullable = false, unique = true)
    private Long chatId;

    @Column(nullable = false, unique = true)
    private Long senderId;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Message(Long id, String text, Long chatId, Long senderId, LocalDateTime timestamp) {
        this.id = id;
        this.text = text;
        this.chatId = chatId;
        this.senderId = senderId;
        this.timestamp = timestamp;
    }

    public Message() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(text, message.text) && Objects.equals(chatId, message.chatId) && Objects.equals(senderId, message.senderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, chatId, senderId);
    }
}
