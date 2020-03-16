package homework.cardealer.service;

import homework.cardealer.domain.dto.seed.SupplierSeedDto;
import homework.cardealer.domain.dto.view.SupplierIdNamePartsCountViewDto;
import homework.cardealer.domain.entity.Supplier;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(SupplierSeedDto[] supplierSeedDtos);

    Supplier getRandomSupplier();

    List<SupplierIdNamePartsCountViewDto> getAllLocalSuppliers();
}
