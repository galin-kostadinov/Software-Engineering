package homework.cardealer.service.impl;

import homework.cardealer.domain.dto.seed.SupplierSeedDto;
import homework.cardealer.domain.dto.view.SupplierIdNamePartsCountViewDto;
import homework.cardealer.domain.dto.view.SupplierIdNamePartsCountViewRootDto;
import homework.cardealer.domain.entity.Supplier;
import homework.cardealer.repository.SupplierRepository;
import homework.cardealer.service.SupplierService;
import homework.cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> list) {
        for (SupplierSeedDto supplierDto : list) {
            if (!this.validatorUtil.isValid(supplierDto)) {
                this.validatorUtil.validations(supplierDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                continue;
            }

            Supplier supplierInBase = this.supplierRepository.getSupplierByName(supplierDto.getName()).orElse(null);
            if (supplierInBase != null) {
                continue;
            }

            Supplier supplier = this.modelMapper.map(supplierDto, Supplier.class);
            this.supplierRepository.saveAndFlush(supplier);
        }
    }

    @Override
    public SupplierSeedDto getRandomSupplierDto() {
        long count = this.supplierRepository.count();

        Random random = new Random();

        Supplier supplier = null;

        while (supplier == null) {
            long id = random.nextInt((int) count) + 1;
            supplier = this.supplierRepository.findById(id).orElse(null);
        }

        return this.modelMapper.map(supplier, SupplierSeedDto.class);
    }

    @Override
    public SupplierIdNamePartsCountViewRootDto getAllLocalSuppliers() {
        List<SupplierIdNamePartsCountViewDto> dtos = this.supplierRepository
                .getAllLocalSuppliers()
                .stream()
                .map(s -> {
                    SupplierIdNamePartsCountViewDto dto =
                            modelMapper.map(s, SupplierIdNamePartsCountViewDto.class);

                    dto.setPartsCount(s.getParts().size());
                    return dto;
                })
                .collect(Collectors.toList());

        return new SupplierIdNamePartsCountViewRootDto(dtos);
    }
}
