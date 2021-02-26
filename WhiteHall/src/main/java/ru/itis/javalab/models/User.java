package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Image image_id;
    private UUID confirmCode;

    @Builder.Default
    private State state = State.NOT_CONFIRMED;

    public enum State {
        CONFIRMED("CONFIRMED"),
        NOT_CONFIRMED("NOT_CONFIRMED");

        private final String state;

        State(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}
