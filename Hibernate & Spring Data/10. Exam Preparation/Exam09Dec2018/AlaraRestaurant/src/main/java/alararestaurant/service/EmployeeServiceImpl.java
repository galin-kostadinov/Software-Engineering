package alararestaurant.service;

import alararestaurant.domain.dtos.seed.EmployeeSeedDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static alararestaurant.constant.GlobalConstants.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PositionService positionService;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionService positionService, FileUtil fileUtil, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.employeeRepository = employeeRepository;
        this.positionService = positionService;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEES_SEED_PATH);
    }

    @Override
    public String importEmployees(String employees) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        EmployeeSeedDto[] employeeSeedDtos =
                this.gson.fromJson(new FileReader(EMPLOYEES_SEED_PATH), EmployeeSeedDto[].class);

        for (EmployeeSeedDto employeeSeedDto : employeeSeedDtos) {
            if (!this.validationUtil.isValid(employeeSeedDto)) {
                sb.append("Invalid data format.").append(System.lineSeparator());
                continue;
            }

            Position position = this.positionService.getPositionByName(employeeSeedDto.getPosition());

            Employee employee = this.modelMapper.map(employeeSeedDto, Employee.class);

            employee.setPosition(position);

            this.employeeRepository.saveAndFlush(employee);

            sb.append(String.format("Record %s successfully imported.", employee.getName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return this.employeeRepository.findByName(name).orElse(null);
    }
}
