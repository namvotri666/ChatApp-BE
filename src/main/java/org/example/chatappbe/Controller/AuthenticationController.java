package org.example.chatappbe.Controller;

import org.example.chatappbe.Exception.UserAlreadyExistException;
import org.example.chatappbe.Model.DTO.UserLoginDTO;
import org.example.chatappbe.Model.DTO.UserRegisterDTO;
import org.example.chatappbe.Model.Entity.User;
import org.example.chatappbe.Model.Response.ApiResponse;
import org.example.chatappbe.Model.Response.LoginResponse;
import org.example.chatappbe.Service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/register")
    public ApiResponse<Object> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            User user = authenticationService.register(userRegisterDTO);
            if (user != null) {
                return ApiResponse.builder()
                        .code(200)
                        .message("Đăng ký thành công")
                        .data(user)
                        .success(true)
                        .build();
            } else {

            }
        } catch (UserAlreadyExistException e) {
            return ApiResponse.builder()
                    .success(false)
                    .code(409)
                    .message(e.getMessage())
                    .build();
        }

        return ApiResponse.builder()
                .code(500)
                .success(false)
                .message("Đăng ký thất bại")
                .build();
    }
}
