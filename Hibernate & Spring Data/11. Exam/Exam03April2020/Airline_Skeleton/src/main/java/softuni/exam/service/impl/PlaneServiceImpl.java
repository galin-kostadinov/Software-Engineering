package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.seed.xml.PlaneSeedDto;
import softuni.exam.models.dto.seed.xml.PlanesRootSeedDto;
import softuni.exam.models.entity.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;

import static softuni.exam.constant.GlobalConstants.PLANES_SEED_PATH;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;
    private final ModelMapper modelMapper;
    private final FileIOUtil fileIOUtil;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, ModelMapper modelMapper, FileIOUtil fileIOUtil,
                            ValidationUtil validationUtil, XmlParser xmlParser) {
        this.planeRepository = planeRepository;
        this.modelMapper = modelMapper;
        this.fileIOUtil = fileIOUtil;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() {
        try {
            return fileIOUtil.readFileContent(PLANES_SEED_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String importPlanes() {
        StringBuilder sb = new StringBuilder();

        PlanesRootSeedDto planesRootSeedDtos =
                xmlParser.objectFromFile(PlanesRootSeedDto.class, PLANES_SEED_PATH);

        for (PlaneSeedDto planesSeedDto : planesRootSeedDtos.getPlanes()) {
            if (!validationUtil.isValid(planesSeedDto)) {
                sb.append("Invalid Plane").append(System.lineSeparator());
                continue;
            }

            if (planeRepository.findByRegisterNumber(planesSeedDto.getRegisterNumber()) != null) {
                sb.append("Invalid Plane").append(System.lineSeparator());
                continue;
            }

            Plane plane = this.modelMapper.map(planesSeedDto, Plane.class);

            planeRepository.saveAndFlush(plane);

            sb.append(String.format("Successfully imported Plane %s", plane.getRegisterNumber()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public Plane getPlaneByRegisterNumber(String registerNumber) {
        return planeRepository.findByRegisterNumber(registerNumber);
    }
}
