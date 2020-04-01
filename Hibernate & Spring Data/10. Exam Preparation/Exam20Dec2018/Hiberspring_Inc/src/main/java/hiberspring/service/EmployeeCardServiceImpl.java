package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.dto.seed.EmployeeCardSeedDto;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private final EmployeeCardRepository employeeCardRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.employeeCardRepository = employeeCardRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return fileUtil.readFile(Constants.EMPLOYEE_CARDS_SEED_PATH);
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) {
        StringBuilder sb = new StringBuilder();

        EmployeeCardSeedDto[] employeeCardSeedDtos = this.gson.fromJson(employeeCardsFileContent, EmployeeCardSeedDto[].class);

        for (EmployeeCardSeedDto employeeCardSeedDto : employeeCardSeedDtos) {
            if (!this.validationUtil.isValid(employeeCardSeedDto)) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            if (this.employeeCardRepository.findByNumber(employeeCardSeedDto.getNumber()).orElse(null) != null) {
                continue;
            }

            EmployeeCard employeeCard = this.modelMapper.map(employeeCardSeedDto, EmployeeCard.class);

            this.employeeCardRepository.saveAndFlush(employeeCard);

            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, "Employee Card", employeeCard.getNumber()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public EmployeeCard getEmployeeCardByCardNumber(String card) {
        return this.employeeCardRepository.findByNumber(card).orElse(null);
    }
}
