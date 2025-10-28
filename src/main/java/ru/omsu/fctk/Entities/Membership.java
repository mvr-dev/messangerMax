package ru.omsu.fctk.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import ru.omsu.fctk.Entities.enums.Role;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private ChatRoom chatRoom;

    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private LocalDateTime joinedAt;

    public Membership(Long id, ChatRoom chatRoom, User user, Role role, LocalDateTime joinedAt) {
        this.id = id;
        this.chatRoom = chatRoom;
        this.user = user;
        this.role = role;
        this.joinedAt = joinedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return Objects.equals(id, that.id) && Objects.equals(chatRoom, that.chatRoom) && Objects.equals(user, that.user) && role == that.role && Objects.equals(joinedAt, that.joinedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatRoom, user, role, joinedAt);
    }
}
