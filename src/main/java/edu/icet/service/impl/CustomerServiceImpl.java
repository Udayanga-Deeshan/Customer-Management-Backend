package edu.icet.service.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final ModelMapper mapper;
   final CustomerRepository repository;
    @Override
    public void addCustomer(Customer customer)
    {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    public List<Customer> getAll(){
        List<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> all = repository.findAll();


        for(CustomerEntity customerEntity:all){
            customerList.add(mapper.map(customerEntity,Customer.class));
        }

        return  customerList;
    }
}
