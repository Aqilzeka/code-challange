package az.ibatech.codechallange.controller;

import az.ibatech.codechallange.entity.db.Customer;
import az.ibatech.codechallange.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping
@AllArgsConstructor
public class XUserController {

    private List<Customer> customers = new ArrayList<>();
    private final CustomerService customerService;

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("getCustomersBy/{amount}")
    public ResponseEntity<List<Customer>> getCustomer(@PathVariable Double amount) {
         List<Customer> customerList = customerService.getAll().stream().filter(data ->
                data.getMonthlyPayment().equals(amount)).collect(Collectors.toList());

         customers.addAll(customerList);
         return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PostMapping("sentToManager")
    public ResponseEntity<String> sentToManager() {
        sendService(customers);
        return customers.isEmpty() ? new ResponseEntity<>("Your List Is Empty", HttpStatus.OK) :
                new ResponseEntity<>("Successfully send ", HttpStatus.OK);
    }


    private void sendService(List<Customer> customers) {
        customers.forEach(log::info);
    }
}
