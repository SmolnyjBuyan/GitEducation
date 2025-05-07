package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smolny.homework_03.dto.UserRequest;
import ru.smolny.homework_03.exception.RoleNotFoundException;
import ru.smolny.homework_03.model.Role;
import ru.smolny.homework_03.model.RoleType;
import ru.smolny.homework_03.model.User;
import ru.smolny.homework_03.repository.RoleRepository;
import ru.smolny.homework_03.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User create(UserRequest request) {
        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getFirstname()
        );
        Role role = roleRepository.findByName(RoleType.ADMIN)
                .orElseThrow(() -> new RoleNotFoundException(RoleType.ADMIN));
        user.addRole(role);
        return userRepository.save(user);
    }
}
