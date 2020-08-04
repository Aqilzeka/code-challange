package az.ibatech.codechallange.repository;

import az.ibatech.codechallange.entity.db.XUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface XUserRepo extends JpaRepository<XUser, Long> {
    Optional<XUser> findByUsername(String username);
}
