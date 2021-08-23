package pl.sdacademy.pewex.user.mappers;

import org.junit.jupiter.api.Test;
import pl.sdacademy.pewex.user.db.UserEntity;
import pl.sdacademy.pewex.user.model.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    private final UserMapper sut = new UserMapper();

    @Test
    void shouldMapEntityToUser(){

        UserEntity entity = UserEntity.builder()
                .userName("Test user")
                .password("Test password")
                .role("Test role")
                .build();

        User user = User.builder()
                .userName("Test user")
                .password("Test password")
                .role("Test role")
                .build();

        Optional<User> result = sut.mapEntityToUser(entity);

        assertThat(result)
                .isNotEmpty()
                .contains(user);
    }

    @Test
    void shouldReturnEmptyOptionalIfNullEntity(){
        Optional<User> result = sut.mapEntityToUser(null);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldMapUserToEntity(){

        UserEntity entity = UserEntity.builder()
                .userName("Test user")
                .password("Test password")
                .role("Test role")
                .build();

        User user = User.builder()
                .userName("Test user")
                .password("Test password")
                .role("Test role")
                .build();

        UserEntity result = sut.mapUserToEntity(user);

        assertThat(result).isEqualTo(entity);

    }

}