package com.fittapp.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittapp.auth.dto.LoginDTO;
import com.fittapp.auth.dto.RegisterDTO;
import com.fittapp.auth.model.Role;
import com.fittapp.auth.model.User;
import com.fittapp.auth.repository.RoleRepository;
import com.fittapp.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final ObjectMapper jsonMapper;

    public AuthController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDTO) throws JsonProcessingException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(loginDTO), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO) throws JsonProcessingException {

        // add check for email exists in DB
        if(userRepository.existsByEmail(registerDTO.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(registerDTO), HttpStatus.OK);

    }

    @GetMapping("/currentUser")
    public ResponseEntity<?> currentUser(@RequestBody String email) throws JsonProcessingException {

        Optional<User> currentUser = userRepository.findByEmail(email);

        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(currentUser), HttpStatus.OK);

    }

    @GetMapping("/allUser")
    public ResponseEntity<?> allUser() throws JsonProcessingException {

        List<User> users = userRepository.findAll();

        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(users), HttpStatus.OK);

    }
}
