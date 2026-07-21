package org.example.chatappbe.Model.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "conversation")
@Builder
@AllArgsConstructor
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
//    private String conversationType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
