package pl.sdacademy.pewex.user.validators;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.user.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {

    public List<String> isValid(User user){
        List<String> result = new ArrayList<>();

        if(user.getUserName() == null || user.getUserName().isEmpty()){
            result.add("User name required");
        }
        if(user.getPassword() == null || user.getPassword().length() < 6){
            result.add("Password nedds to have at least 6 characters");
        }

        return result;
    }
}
