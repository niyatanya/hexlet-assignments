package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> create(User data) {
        return userRepository.save(data);
    }

    public Mono<User> update(User data, Long id) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setFirstName(data.getFirstName());
                    existingUser.setLastName(data.getLastName());
                    existingUser.setEmail(data.getEmail());
                    LOGGER.info("Input user: " + existingUser.toString());
                    return userRepository.save(existingUser);
                });
    }

    public Mono<Void> delete(Long id) {
        return userRepository.deleteById(id);
    }
    // END
}
