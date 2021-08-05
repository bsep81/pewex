package pl.sdacademy.pewex.user.service;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sdacademy.pewex.user.db.UserEntity;
import pl.sdacademy.pewex.user.exceptions.UserException;
import pl.sdacademy.pewex.user.mappers.UserMapper;
import pl.sdacademy.pewex.user.model.User;
import pl.sdacademy.pewex.user.repository.UserRepository;
import pl.sdacademy.pewex.user.validators.UserValidator;

import java.util.List;


@Service
public
class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserValidator userValidator;
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.userValidator = userValidator;
    }


    public User addUser(User user) {
        List<String> errors = userValidator.isValid(user);
        if (!errors.isEmpty()){
            LOG.info("User details not valid");
            throw new UserException(Strings.join(errors, ','));
        }


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity created = userRepository.save(userMapper.mapUserToEntity(user));
        LOG.info("Succesfully added user {} to database", user.getUserName());
        return  userMapper.mapEntityToUser(created).get();
    }
}
