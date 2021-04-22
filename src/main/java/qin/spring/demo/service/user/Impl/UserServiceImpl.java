package qin.spring.demo.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import qin.spring.demo.dao.user.UserRepository;
import qin.spring.demo.modules.auth.JwtTokenUtil;
import qin.spring.demo.service.user.UserService;
import qin.spring.demo.entity.user.User;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Qualifier("jwtUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public User findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findOneByPhone(String phone) { return userRepository.findByPhone(phone); }

    @Override
    public Optional<User> findOneById(Long id) { return userRepository.findById(id); }
}
