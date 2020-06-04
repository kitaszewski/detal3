package pl.rawinet.detal3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rawinet.detal3.model.Customer;
import pl.rawinet.detal3.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository repository){
        this.customerRepo = repository;
    }

    public List<Customer> findAll(){
        return customerRepo.findAll();
    }

    public Optional<Customer> findById(Long id){
        return customerRepo.findById(id);
    }

    public Customer save(Customer customer){
        return customerRepo.saveAndFlush(customer);
    }

    public void deleteById(Long id){
        customerRepo.deleteById(id);
    }
}
