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
    public void seedParts(PartSeedDto[] partSeedDtos) {
        for (PartSeedDto partSeedDto : partSeedDtos) {
            if (!this.validatorUtil.isValid(partSeedDto)) {
                this.validatorUtil.validations(partSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                continue;
            }

            Part partInBase = this.partRepository.getPartByName(partSeedDto.getName()).orElse(null);

            if (partInBase != null) {
                continue;
            }

            Part part = this.modelMapper.map(partSeedDto, Part.class);

            part.setSupplier(this.supplierService.getRandomSupplier());

            this.partRepository.saveAndFlush(part);
        }
    }

    @Override
    public Set<Part> getRandomPartSet() {
        final int lowerBound = 10;
        final int upperBound = 20;

        Set<Part> parts = new HashSet<>();

        Random random = new Random();

        int count = random.nextInt((upperBound - lowerBound) + 1) + lowerBound;

        for (int i = 0; i< count; i++){
            parts.add(getRandomPart());
        }

        return parts;
    }

    private Part getRandomPart() {
        long count = this.partRepository.count();

        Random random = new Random();

        Part part = null;

        while (part == null) {
            long id = random.nextInt((int) count - 1) + 1;
            part = this.partRepository.findById(id).orElse(null);
        }

        return part;
    }
}
