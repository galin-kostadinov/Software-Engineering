package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.seed.json.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;

import static softuni.exam.constant.GlobalConstants.TOWNS_SEED_PATH;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final FileIOUtil fileIOUtil;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, FileIOUtil fileIOUtil,
                           ValidationUtil validationUtil, Gson gson) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.fileIOUtil = fileIOUtil;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() {
        try {
            return fileIOUtil.readFileContent(TOWNS_SEED_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder sb = new StringBuilder();

        TownSeedDto[] townSeedDtos = gson.fromJson(fileIOUtil.readFileContent(TOWNS_SEED_PATH), TownSeedDto[].class);

        for (TownSeedDto townSeedDto : townSeedDtos) {
            if (!validationUtil.isValid(townSeedDto)) {
                sb.append("Invalid Town").append(System.lineSeparator());
                continue;
            }

            if (townRepository.findByName(townSeedDto.getName()) != null) {
                sb.append("Invalid Town").append(System.lineSeparator());
                continue;
            }

            Town town = this.modelMapper.map(townSeedDto, Town.class);

            townRepository.saveAndFlush(town);

            sb.append(String.format("Successfully imported Town %s - %d", town.getName(), town.getPopulation()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public Town getByName(String townName) {
        return townRepository.findByName(townName);
    }
}
