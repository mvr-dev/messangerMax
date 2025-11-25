package ru.omsu.fctk.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import ru.omsu.fctk.Entities.enums.State;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Table(name = "chatrooms")
public class ChatRoom {

    public ChatRoom() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private State state;

    @Column
    private LocalDateTime createdAt;

    @Column
    private String createdBy;

    @Column
    private LocalDateTime expiryAt;

    public ChatRoom(Long id,
                    String name,
                    State state,
                    LocalDateTime createdAt,
                    String createdBy,
                    LocalDateTime expiryAt) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.expiryAt = expiryAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChatRoom chatRoom = (ChatRoom) o;
        return Objects.equals(id, chatRoom.id) && Objects.equals(name, chatRoom.name) && state == chatRoom.state && Objects.equals(createdAt, chatRoom.createdAt) && Objects.equals(createdBy, chatRoom.createdBy) && Objects.equals(expiryAt, chatRoom.expiryAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, createdAt, createdBy, expiryAt);
    }
}
