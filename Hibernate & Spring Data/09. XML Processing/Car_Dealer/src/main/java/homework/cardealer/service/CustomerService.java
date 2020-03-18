package homework.cardealer.service;

import homework.cardealer.domain.dto.seed.CustomerSeedDto;
import homework.cardealer.domain.dto.view.CustomerNameBoughtCarsSpendMoneyViewRootDto;
import homework.cardealer.domain.dto.view.CustomerViewRootDto;
import homework.cardealer.domain.entity.Customer;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> customerSeedDtos);

    List<Customer> getAllCustomers();

    CustomerViewRootDto getOrderedCustomers();

    CustomerNameBoughtCarsSpendMoneyViewRootDto getAllTotalSalesByCustomer();
}
