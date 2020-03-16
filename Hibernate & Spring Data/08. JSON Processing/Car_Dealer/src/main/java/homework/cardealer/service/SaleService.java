package homework.cardealer.service;

import homework.cardealer.domain.dto.view.SaleWithCarCustomerDiscountPrice;

import java.util.List;

public interface SaleService {
    void seedSales();

    List<SaleWithCarCustomerDiscountPrice> getAllTotalSalesByCustomer();
}
