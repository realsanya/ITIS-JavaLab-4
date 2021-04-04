package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(unique=true)
    private String email;
    private String hashPassword;
    @Column(name="confirm_code")
    private UUID confirmCode;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public enum State {
        CONFIRMED("CONFIRMED"),
        NOT_CONFIRMED("NOT_CONFIRMED"),
        ACTIVE("ACTIVE"),
        BANNED("BANNED");

        private final String state;

        State(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    public enum Role {
        ADMIN, USER
    }

    public boolean isActive(){
        return  this.state == State.ACTIVE;
    }

    public boolean isBanned(){
        return  this.state == State.BANNED;
    }

    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }
}
