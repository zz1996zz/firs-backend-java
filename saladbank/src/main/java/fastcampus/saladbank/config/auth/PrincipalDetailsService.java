package fastcampus.saladbank.config.auth;

import fastcampus.saladbank.biz.domain.User;
import fastcampus.saladbank.biz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User findUser = userRepository.findByUsername(username);
        if (findUser != null) {
            PrincipalDetails principalDetails = new PrincipalDetails(findUser);
            log.info("username={}", principalDetails.getUsername());
            log.info("password={}", principalDetails.getPassword());
//            return new PrincipalDetails(findMember);
            return principalDetails;
        }
        return null;
    }
}
