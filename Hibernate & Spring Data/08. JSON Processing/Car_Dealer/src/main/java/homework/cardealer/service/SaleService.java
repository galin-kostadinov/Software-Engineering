package homework.cardealer.service;

import homework.cardealer.domain.dto.view.SaleWithCarCustomerDiscountPriceViewDto;

import java.util.List;

public interface SaleService {
    void seedSales();

    List<SaleWithCarCustomerDiscountPriceViewDto> getAllTotalSalesByCustomer();
}
