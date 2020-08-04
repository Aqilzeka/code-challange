package az.ibatech.codechallange.config;

import az.ibatech.codechallange.entity.XUserDetails;
import az.ibatech.codechallange.entity.db.XUser;
import az.ibatech.codechallange.repository.XUserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Log4j2
@Configuration
public class UserDetailsServiceJPA  implements UserDetailsService {
    private final XUserRepo repo;

    public UserDetailsServiceJPA(XUserRepo repo) {
        this.repo = repo;
    }

    public static UserDetails mapper_to_xUserDetails(XUser xuser) {
        return new XUserDetails(
                xuser.getId(),
                xuser.getUsername(),
                xuser.getPassword(),
                xuser.getRoles()
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(String.format(">>>> loading user details for user: %s", username));
        return repo.findByUsername(username)
                .map(UserDetailsServiceJPA::mapper_to_xUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User: %s isn't found in our DB", username)
                ));
    }
}
