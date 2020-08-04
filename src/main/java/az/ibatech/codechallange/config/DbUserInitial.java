package az.ibatech.codechallange.config;

import az.ibatech.codechallange.entity.db.XUser;
import az.ibatech.codechallange.repository.XUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
public class DbUserInitial {

    private final XUserRepo repo;
    private final PasswordEncoder enc;

    public DbUserInitial(XUserRepo repo, PasswordEncoder enc) {
        this.repo = repo;
        this.enc = enc;
    }

    public void create() {
        repo.saveAll(Arrays.asList(
                new XUser("ali", enc.encode(new String("123c")), "MANAGER"),
                new XUser("ayla", enc.encode(new String("234c")), "ADMIN")
        ));
    }
}
