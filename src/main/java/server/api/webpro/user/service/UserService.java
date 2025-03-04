package server.api.webpro.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.webpro.user.dto.*;
import server.api.webpro.user.entity.User;
import server.api.webpro.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserCreateRequest request) {
        userRepository.save(User.builder()
                        .name(request.getName())
                        .age(request.getAge())
                        .email(request.getEmail())
                .build());
    }

    public List<UserResponse> getAllUser() {return userRepository.findAll().stream().map(UserResponse::of).collect(Collectors.toList());}


}