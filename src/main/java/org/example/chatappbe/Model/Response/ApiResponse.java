package org.example.chatappbe.Model.Response;
import lombok.*;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T>{
    private boolean success;
    private String message;
    private int code;
    private T data; // Chứa dữ liệu trả về


}