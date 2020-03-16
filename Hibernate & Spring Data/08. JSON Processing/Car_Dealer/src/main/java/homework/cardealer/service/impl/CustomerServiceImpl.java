package homework.cardealer.service.impl;

import homework.cardealer.domain.dto.seed.CustomerSeedDto;
import homework.cardealer.domain.dto.view.CustomerIdNameBDIsYoungerDriverViewDto;
import homework.cardealer.domain.dto.view.CustomerNameBoughtCarsSpendMoneyViewDto;
import homework.cardealer.domain.entity.Customer;
import homework.cardealer.domain.entity.Sale;
import homework.cardealer.repository.CustomerRepository;
import homework.cardealer.service.CustomerService;
import homework.cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomers(CustomerSeedDto[] customerSeedDtos) {
        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {
            if (!this.validatorUtil.isValid(customerSeedDto)) {
                this.validatorUtil.validations(customerSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                continue;
            }

            Customer customer = this.modelMapper.map(customerSeedDto, Customer.class);

            this.customerRepository.saveAndFlush(customer);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public List<CustomerIdNameBDIsYoungerDriverViewDto> getOrderedCustomers() {
        return this.customerRepository
                .getAllOrderByBirthDateAndYoungDriver()
                .stream()
                .map(c -> {
                    CustomerIdNameBDIsYoungerDriverViewDto dto =
                            this.modelMapper.map(c, CustomerIdNameBDIsYoungerDriverViewDto.class);
                    dto.setPurchases(new Sale[0]);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerNameBoughtCarsSpendMoneyViewDto> getAllTotalSalesByCustomer() {
        return this.customerRepository
                .getAllCustomersNameBoughtCarsAndSpendMoney()
                .stream()
                .map(c ->
                        new CustomerNameBoughtCarsSpendMoneyViewDto(
                                c[0].toString(),
                                Integer.parseInt(c[1].toString()),
                                new BigDecimal(c[2].toString())))
                .collect(Collectors.toList());
    }
}
