package pl.sdacademy.pewex.user.validators;

import org.junit.jupiter.api.Test;
import pl.sdacademy.pewex.user.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserValidatorTest {

    private final UserValidator sut = new UserValidator();

    @Test
    void shouldReturnEmptyListIfUserIsValid(){

        User user = User.builder()
                .userName("Test user")
                .password("Test password")
                .role("Test role")
                .build();

        List<String> results = sut.isValid(user);

        assertThat(results).isEmpty();
    }

    @Test
    void shouldReturnListOfErrorsIfUserIsNotValid(){

        User user = new User();

        List<String> results = sut.isValid(user);

        assertThat(results).containsExactly("User name required", "Password nedds to have at least 6 characters");
    }


}