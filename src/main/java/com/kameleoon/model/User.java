package com.kameleoon.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Email(regexp = ".+@.+\\..+")
    @Column(name = "email")
    private String email;

    @NotNull(message = "password can't be null")
    @NotEmpty(message = "password must be filled")
    @Size(max = 50, message = "Max 50 symbols")
    @Column(name = "password")
    private String password;

    public User() {}

    public User(Long userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(super.getCreated(), user.getCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, super.getCreated());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created=" + super.getCreated() +
                '}';
    }
}
