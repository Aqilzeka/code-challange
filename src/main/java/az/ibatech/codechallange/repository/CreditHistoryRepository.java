package az.ibatech.codechallange.repository;


import az.ibatech.codechallange.entity.db.CreditHistories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditHistoryRepository extends JpaRepository<CreditHistories,Long> {
}
