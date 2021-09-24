package quickstart;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//If you wanna allow for everyone then simply use @CrossOrigin
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = {"http://localhost:7777", "http://someserver:8080"})
public class UserController {

    // standard constructors
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

    @CrossOrigin
	@GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
