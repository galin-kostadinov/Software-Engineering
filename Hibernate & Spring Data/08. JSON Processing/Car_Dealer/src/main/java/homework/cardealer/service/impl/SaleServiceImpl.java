package homework.cardealer.service.impl;

import homework.cardealer.domain.dto.view.SaleWithCarCustomerDiscountPriceViewDto;
import homework.cardealer.domain.entity.Car;
import homework.cardealer.domain.entity.Customer;
import homework.cardealer.domain.entity.Part;
import homework.cardealer.domain.entity.Sale;
import homework.cardealer.repository.SaleRepository;
import homework.cardealer.service.CarService;
import homework.cardealer.service.CustomerService;
import homework.cardealer.service.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        List<Car> cars = this.carService.getAllCastWithoutCustomer();
        List<Customer> customers = this.customerService.getAllCustomers();
        Double[] discouns = {0d, 0.05d, 0.1d, 0.15d, 0.2d, 0.3d, 0.4d, 0.5d};

        Random random = new Random();

        List<Sale> sales = new ArrayList<>();

        for (Car car : cars) {
            Sale sale = new Sale();
            sale.setCar(car);
            sale.setCustomer(customers.get(random.nextInt(customers.size())));
            sale.setDiscount(discouns[random.nextInt(discouns.length)]);
            this.saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public List<SaleWithCarCustomerDiscountPriceViewDto> getAllTotalSalesByCustomer() {
        return this.saleRepository
                .findAll()
                .stream()
                .map(s -> {
                    SaleWithCarCustomerDiscountPriceViewDto dto =
                            modelMapper.map(s, SaleWithCarCustomerDiscountPriceViewDto.class);

                    if (s.getCustomer().isYoungDriver()) {
                        dto.setDiscount(dto.getDiscount() + 0.05);
                    }

                    BigDecimal price =
                            s.getCar()
                                    .getParts()
                                    .stream()
                                    .map(Part::getPrice)
                                    .reduce(BigDecimal.ZERO, (subtotal, element) -> subtotal.add(element));

                    dto.setPrice(price);
                    dto.setPriceWithDiscount(price.subtract(price.multiply(BigDecimal.valueOf(dto.getDiscount()))));

                    return dto;
                })
                .collect(Collectors.toList());
    }
}
