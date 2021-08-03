package pl.sdacademy.pewex.user.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.user.db.UserEntity;
import pl.sdacademy.pewex.user.model.User;

import java.util.Optional;

@Component
public class UserMapper {

    public Optional<User> mapEntityToUser(UserEntity entity) {

        if (entity == null) {
            return Optional.empty();
        }

        User user = User.builder()
                .userName(entity.getUserName())
                .password(entity.getPassword())
                .role(entity.getRole())
                .build();

        return Optional.of(user);
    }

    public UserEntity mapUserToEntity(User user) {

        return UserEntity.builder()
                .userName(user.getUserName())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
