package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import static ru.itis.javalab.dto.UserDto.from;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean userIsExist(String email) {
        return userRepository.findUserByEmail(email) != null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return from(userRepository.findAll());
    }

    @Override
    public void banAll() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (!user.isAdmin()) {
                user.setState(User.State.BANNED);
                userRepository.save(user);
            }
        }
    }

}
