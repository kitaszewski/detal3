package pl.rawinet.detal3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rawinet.detal3.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
