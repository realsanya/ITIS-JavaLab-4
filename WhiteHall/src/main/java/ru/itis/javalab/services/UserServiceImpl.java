package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.interfaces.UserRepository;
import ru.itis.javalab.services.interfaces.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(userRepository.findAll());
    }

    @Override
    public boolean userIsExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(
                User.builder()
                        .first_name(user.getFirst_name())
                        .last_name(user.getLast_name())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .image_id(user.getImage_id())
                        .build()
        );
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id);
    }
}
