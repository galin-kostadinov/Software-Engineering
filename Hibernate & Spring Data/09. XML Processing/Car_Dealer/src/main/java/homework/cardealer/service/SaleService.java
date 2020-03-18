package homework.cardealer.service;

import homework.cardealer.domain.dto.view.SaleWithCarCustomerDiscountPriceViewRootDto;

public interface SaleService {
    void seedSales();

    SaleWithCarCustomerDiscountPriceViewRootDto getAllTotalSalesByCustomer();
}
