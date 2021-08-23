package pl.sdacademy.pewex.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sdacademy.pewex.user.db.UserEntity;
import pl.sdacademy.pewex.user.mappers.UserMapper;
import pl.sdacademy.pewex.user.model.User;
import pl.sdacademy.pewex.user.repository.UserRepository;
import pl.sdacademy.pewex.user.validators.UserValidator;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserValidator userValidator;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnCreatedUser(){

        User user = User.builder()
                .userName("Test user")
                .password("Test password")
                .role("Test role")
                .build();

        UserEntity entity = UserEntity.builder()
                .userName("Test user")
                .password("Test password")
                .role("Test role")
                .build();

        when(userValidator.isValid(user)).thenReturn(new ArrayList<>());
        when(passwordEncoder.encode(user.getPassword())).thenReturn(user.getPassword());
        when(userMapper.mapUserToEntity(user)).thenReturn(entity);
        when(userMapper.mapEntityToUser(entity)).thenReturn(Optional.of(user));
        when(userRepository.save(userMapper.mapUserToEntity(user))).thenReturn(entity);


        User saved = userService.addUser(user);

        assertThat(saved).isEqualTo(user);

    }




}