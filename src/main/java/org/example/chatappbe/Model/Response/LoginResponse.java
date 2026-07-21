package org.example.chatappbe.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginResponse<T> {
    private String accessToken;
    private T data;
    private Long expiredIn;
}
