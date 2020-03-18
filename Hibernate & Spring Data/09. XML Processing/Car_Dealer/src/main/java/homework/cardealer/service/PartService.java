package homework.cardealer.service;

import homework.cardealer.domain.dto.seed.PartSeedDto;
import homework.cardealer.domain.entity.Part;

import java.util.List;
import java.util.Set;

public interface PartService {
    void seedParts(List<PartSeedDto> parts);

    Set<Part> getRandomParts();
}
