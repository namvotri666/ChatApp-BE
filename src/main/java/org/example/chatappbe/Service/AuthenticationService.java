package org.example.chatappbe.Service;

import lombok.RequiredArgsConstructor;
import org.example.chatappbe.Exception.InvalidCredientialException;
import org.example.chatappbe.Exception.NotFoundException;
import org.example.chatappbe.Exception.UserAlreadyExistException;
import org.example.chatappbe.Model.DTO.UserRegisterDTO;
import org.example.chatappbe.Model.Entity.User;
import org.example.chatappbe.Model.DTO.UserLoginDTO;
import org.example.chatappbe.Repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(UserRegisterDTO userRegisterDTO) {
        if (userRepository.existsByEmail(userRegisterDTO.getEmail())) {
            throw new UserAlreadyExistException("Email đã tồn tại");
        }
        if (userRepository.existsByPhoneNum(userRegisterDTO.getPhoneNum())) {
            throw new UserAlreadyExistException("Số điện thoại đã tồn tại");
        }
        User user = User.builder().username(userRegisterDTO.getUsername())
                .password(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .name(userRegisterDTO.getName().trim())
                .email(userRegisterDTO.getEmail().toLowerCase().trim())
                .phoneNum(userRegisterDTO.getPhoneNum().trim())
                .createdAt(LocalDateTime.now())
                .build();
        userRepository.save(user);
        return user;
    }

    public String login(UserLoginDTO userLoginDTO) {
        Optional<User> user = userRepository.findByUsername(userLoginDTO.getUsername());
        if (user.isEmpty()) {
            throw new NotFoundException("User không tồn tại");
        }
        else {
            User currentUser = user.get();
            if (user.isPresent()) {
                if (!passwordEncoder.matches(userLoginDTO.getPassword(), currentUser.getPassword())) {
                    throw new InvalidCredientialException("Tài khoản hoặc mật khẩu không chính xác");
                } else {
                    return "";
                }
            }
            else{
                return "";
            }
        }
    }
}
