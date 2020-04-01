package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.domain.dto.seed.BranchSeedDto;
import hiberspring.repository.BranchRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final TownService townService;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, TownService townService, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.branchRepository = branchRepository;
        this.townService = townService;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return fileUtil.readFile(Constants.BRANCHES_SEED_PATH);
    }

    @Override
    public String importBranches(String branchesFileContent) {
        StringBuilder sb = new StringBuilder();

        BranchSeedDto[] branchSeedDtos = this.gson.fromJson(branchesFileContent, BranchSeedDto[].class);

        for (BranchSeedDto branchSeedDto : branchSeedDtos) {
            if (!this.validationUtil.isValid(branchSeedDto)) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Town town = this.townService.getTownByName(branchSeedDto.getTown());

            if (town == null) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Branch branch = this.modelMapper.map(branchSeedDto, Branch.class);
            branch.setTown(town);

            this.branchRepository.saveAndFlush(branch);

            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, "Branch", branch.getName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public Branch getBranchByName(String name) {
        return this.branchRepository.findByName(name).orElse(null);
    }
}
