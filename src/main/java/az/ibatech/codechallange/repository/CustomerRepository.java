package az.ibatech.codechallange.repository;

import az.ibatech.codechallange.entity.db.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByOrderByCreditHistoriesAsc();
}
