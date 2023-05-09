package com.hsa.mysql.index.resource;

import com.hsa.mysql.index.model.CustomerDto;
import com.hsa.mysql.index.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerResource {

  private final CustomerService customerService;

  @GetMapping
  public ResponseEntity<List<CustomerDto>> getCustomerByBirthday(@RequestParam("birthday") String birthday) {
    var customersByBirthday = customerService.getCustomerByBirthday(birthday);
    return ResponseEntity.ok(customersByBirthday);
  }

  @PostMapping("/thousand")
  public ResponseEntity<?> postThousandRecords() {
    customerService.postThousandRecords();
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<Long> postCustomers() {
    customerService.init();
    return ResponseEntity.ok().build();
  }

  @PostMapping("/2")
  public ResponseEntity<Long> postCustomers2() {
    customerService.init2();
    return ResponseEntity.ok().build();
  }

  @PostMapping("/3")
  public ResponseEntity<Long> postCustomers3() {
    customerService.init3();
    return ResponseEntity.ok().build();
  }

  @PostMapping("/4")
  public ResponseEntity<Long> postCustomers4() {
    customerService.init4();
    return ResponseEntity.ok().build();
  }

  @PostMapping("/5")
  public ResponseEntity<Long> postCustomers5() {
    customerService.init5();
    return ResponseEntity.ok().build();
  }

}
