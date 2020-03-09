package pl.rawinet.detal3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rawinet.detal3.model.Customer;
import pl.rawinet.detal3.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {
    private final CustomerService customerService;

    public CustomerAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if(!customer.isPresent()){
            return ResponseEntity.badRequest().header("API-Error", "Klient nie istnieje").build();
        }
        return ResponseEntity.ok(customer.get());
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.save(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
        if(!customerService.findById(id).isPresent()){
            return ResponseEntity.badRequest().header("API-Error", "Klient nie istnieje").build();
        }
        return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if(!customerService.findById(id).isPresent()){
            return ResponseEntity.badRequest().header("API-Error", "Klient nie istnieje").build();
        }

        customerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
