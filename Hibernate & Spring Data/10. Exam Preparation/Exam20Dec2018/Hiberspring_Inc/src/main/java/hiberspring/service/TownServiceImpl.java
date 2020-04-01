package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.entities.Town;
import hiberspring.domain.dto.seed.TownSeedDto;
import hiberspring.repository.TownRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return fileUtil.readFile(Constants.TOWNS_SEED_PATH);
    }

    @Override
    public String importTowns(String townsFileContent) {
        StringBuilder sb = new StringBuilder();

        TownSeedDto[] townSeedDtos = this.gson.fromJson(townsFileContent, TownSeedDto[].class);

        for (TownSeedDto townSeedDto : townSeedDtos) {
            if (!this.validationUtil.isValid(townSeedDto)) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Town town = this.modelMapper.map(townSeedDto, Town.class);

            this.townRepository.saveAndFlush(town);

            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, "Town", town.getName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public Town getTownByName(String name) {
        return this.townRepository.findByName(name).orElse(null);
    }
}
