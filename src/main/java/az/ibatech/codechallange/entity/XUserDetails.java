package az.ibatech.codechallange.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
public class XUserDetails implements UserDetails {

    private final int id;
    private final String username;
    private final String password;
    private final String[] roles;

    public XUserDetails(int id, String username, String password, String[] roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return String.format("XUserDetails[%d:'%s':'%s':{%s}]", id, username, password, Arrays.toString(roles));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles)
                .map(s -> "ROLE_"+ s)  // Stream<String>
                .map(s -> new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return s;
                    }
                })
//        .map(s -> (GrantedAuthority) () -> s) // 2 lambdas in one line
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
