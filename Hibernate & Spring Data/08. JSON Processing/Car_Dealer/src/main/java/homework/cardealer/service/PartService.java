package homework.cardealer.service;

import homework.cardealer.domain.dto.seed.PartSeedDto;
import homework.cardealer.domain.entity.Part;

import java.util.Set;

public interface PartService {
    void seedParts(PartSeedDto[] parts);

    Set<Part> getRandomPartSet();
}
