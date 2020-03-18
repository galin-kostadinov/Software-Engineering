package homework.cardealer.service;

import homework.cardealer.domain.dto.seed.SupplierSeedDto;
import homework.cardealer.domain.dto.view.SupplierIdNamePartsCountViewRootDto;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(List<SupplierSeedDto> list);

    SupplierSeedDto getRandomSupplierDto();

    SupplierIdNamePartsCountViewRootDto getAllLocalSuppliers();
}
