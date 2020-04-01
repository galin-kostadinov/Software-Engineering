package hiberspring.service;

import hiberspring.common.Constants;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.dto.seed.xml.EmployeeSeedDto;
import hiberspring.domain.dto.seed.xml.EmployeeSeedRootDto;
import hiberspring.repository.EmployeeRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BranchService branchService, EmployeeCardService employeeCardService, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.employeeRepository = employeeRepository;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return fileUtil.readFile(Constants.EMPLOYEES_SEED_PATH);
    }

    @Override
    public String importEmployees() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        EmployeeSeedRootDto employeeSeedRootDto =
                this.xmlParser.parseXml(EmployeeSeedRootDto.class, Constants.EMPLOYEES_SEED_PATH);

        for (EmployeeSeedDto employeeSeedDto : employeeSeedRootDto.getEmployees()) {
            if (!this.validationUtil.isValid(employeeSeedDto)) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Branch branch = this.branchService.getBranchByName(employeeSeedDto.getBranch());
            EmployeeCard employeeCard = this.employeeCardService.getEmployeeCardByCardNumber(employeeSeedDto.getCard());

            if (branch == null || employeeCard == null || employeeCard.getEmployee() != null) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Employee employee = this.modelMapper.map(employeeSeedDto, Employee.class);
            employee.setBranch(branch);
            employee.setCard(employeeCard);
            this.employeeRepository.saveAndFlush(employee);
            employeeCard.setEmployee(employee);

            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                    "Employee",
                    employee.getFirstName() + " " + employee.getLastName()));

            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder sb = new StringBuilder();
        this.employeeRepository
                .findAllByBranchContainingProductOrderByFullName()
                .forEach(e -> {
                    sb.append(String.format("Name: %s %s", e.getFirstName(), e.getLastName())).append(System.lineSeparator());
                    sb.append(String.format("Position: %s ", e.getPosition())).append(System.lineSeparator());
                    sb.append(String.format("Card Number: %s ", e.getCard().getNumber())).append(System.lineSeparator());
                    sb.append("-------------------------").append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
