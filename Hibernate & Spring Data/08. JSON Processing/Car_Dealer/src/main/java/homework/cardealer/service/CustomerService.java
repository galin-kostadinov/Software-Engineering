package homework.cardealer.service;

import homework.cardealer.domain.dto.seed.CustomerSeedDto;
import homework.cardealer.domain.dto.view.CustomerIdNameBDIsYoungerDriverViewDto;
import homework.cardealer.domain.dto.view.CustomerNameBoughtCarsSpendMoneyViewDto;
import homework.cardealer.domain.entity.Customer;

import java.util.List;

public interface CustomerService {

    void seedCustomers(CustomerSeedDto[] customerSeedDtos);

    List<Customer> getAllCustomers();

    List<CustomerIdNameBDIsYoungerDriverViewDto> getOrderedCustomers();

    List<CustomerNameBoughtCarsSpendMoneyViewDto> getAllTotalSalesByCustomer();
}
