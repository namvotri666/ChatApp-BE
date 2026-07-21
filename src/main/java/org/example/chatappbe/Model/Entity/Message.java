package org.example.chatappbe.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.chatappbe.Enum.MessageType;

@Entity
@Table(name = "message")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private MessageType messageType;
    private String senderId;
    private String conversationId;
    private String content;
    private String createdAt;
}
