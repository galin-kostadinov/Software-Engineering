package homework.cardealer.service.impl;

import homework.cardealer.domain.dto.seed.PartSeedDto;
import homework.cardealer.domain.entity.Part;
import homework.cardealer.domain.entity.Supplier;
import homework.cardealer.repository.PartRepository;
import homework.cardealer.service.PartService;
import homework.cardealer.service.SupplierService;
import homework.cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final SupplierService supplierService;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedParts(List<PartSeedDto> list) {
        for (PartSeedDto partDto : list) {
            if (!this.validatorUtil.isValid(partDto)) {
                this.validatorUtil.validations(partDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                continue;
            }

            Part partInBase = this.partRepository.getPartByName(partDto.getName()).orElse(null);

            if (partInBase != null) {
                continue;
            }

            Part part = this.modelMapper.map(partDto, Part.class);

            part.setSupplier(this.modelMapper.map(this.supplierService.getRandomSupplierDto(), Supplier.class));
            this.partRepository.saveAndFlush(part);
        }
    }

    @Override
    public Set<Part> getRandomParts() {
        final int lowerBound = 10;
        final int upperBound = 20;

        Set<Part> parts = new HashSet<>();

        Random random = new Random();

        int count = random.nextInt((upperBound - lowerBound)) + lowerBound;

        for (int i = 0; i < count; i++) {
            parts.add(getRandomPart());
        }

        return parts;
    }

    private Part getRandomPart() {
        long count = this.partRepository.count();

        Random random = new Random();

        Part part = null;

        while (part == null) {
            long id = random.nextInt((int) count) + 1;
            part = this.partRepository.findById(id).orElse(null);
        }

        return part;
    }
}
