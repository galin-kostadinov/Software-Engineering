package alararestaurant.service;

import alararestaurant.domain.entities.Position;
import alararestaurant.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Position getPositionByName(String name) {
        Position position = this.positionRepository.findByName(name).orElse(null);

        if (position == null) {
            addPosition(name);
            position = this.positionRepository.findByName(name).orElse(null);
        }

        return position;
    }

    private void addPosition(String name) {
        Position position = new Position();
        position.setName(name);
        this.positionRepository.saveAndFlush(position);
    }
}
