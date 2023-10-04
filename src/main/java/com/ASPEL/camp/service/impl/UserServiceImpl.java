package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.model.ERole;
import com.ASPEL.camp.model.Role;
import com.ASPEL.camp.model.User;
import com.ASPEL.camp.payload.request.SignupRequest;
import com.ASPEL.camp.repository.RoleRepository;
import com.ASPEL.camp.repository.UserRepository;
import com.ASPEL.camp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final CampistaServiceImpl campistaService;
    private final PasswordEncoder passwordEncoder;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, CampistaServiceImpl campistaService, PasswordEncoder passwordEncoder, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.campistaService = campistaService;
        this.passwordEncoder = passwordEncoder;
        this.encoder = encoder;
    }


    @Override
    @Transactional
    public void saveUser(SignupRequest signUpRequest) throws Exception {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return;
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ;
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        Campista campista = campistaService.findCampistaByNome(signUpRequest.getCampista().getNome())
                .orElseThrow(() -> new RuntimeException("Error: Campista is not found."));

        user.setCampista(campista);
        user.setRoles(roles);

        userRepository.save(user);
    }
}

