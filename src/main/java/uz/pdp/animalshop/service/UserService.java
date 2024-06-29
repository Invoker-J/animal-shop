package uz.pdp.animalshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.animalshop.entity.User;
import uz.pdp.animalshop.repo.UserRepository;
import uz.pdp.animalshop.service.interfaces.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<User, UUID> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }








    
    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void delete(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> availableUsers() {
        return userRepository.availableUsers();
    }

    public Optional<User> findAvailableUserById(UUID userId) {
        return userRepository.findAvailableUserByUserId(userId);
    }
}
