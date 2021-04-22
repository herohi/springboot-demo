package qin.spring.demo.modules.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import qin.spring.demo.dao.user.UserRepository;
import qin.spring.demo.entity.user.User;
import qin.spring.demo.helpers.response.CodeMsg;
import qin.spring.demo.helpers.exception.GlobalException;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new GlobalException(CodeMsg.NO_SUCH_USER.fill(username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
