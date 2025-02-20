package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    final CustomerService service;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public  void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
        System.out.println(customer);

    }

    @GetMapping("/get-all")
    public List<Customer> getAll(){
        return  service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomer( @PathVariable Integer id){
        System.out.println(id);
        service.deleteCustomer(id);

    }


    @PutMapping("/update-customer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);
    }

    @GetMapping("/search-by-id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Customer searchById( @PathVariable Integer id){
       return service.searchById(id);
    }

    @GetMapping("/search-name/{name}")
    List<Customer> searchByName(@PathVariable String name){
        return  service.searchByname(name);
    }


}
