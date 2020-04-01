package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.seed.xml.PicturesSeedDto;
import softuni.exam.domain.dto.seed.xml.PicturesSeedRootDto;
import softuni.exam.domain.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constant.GlobalConstant.*;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public String importPictures() throws IOException, JAXBException {
        PicturesSeedRootDto picturesSeedRootDto =
                this.xmlParser.objectFromFile(PicturesSeedRootDto.class, PICTURES_SEED_PATH);

        StringBuilder stringBuilder = new StringBuilder();

        for (PicturesSeedDto dtoPic : picturesSeedRootDto.getPictures()) {
            if (!this.validatorUtil.isValid(dtoPic)) {
                stringBuilder.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            Picture picture = this.modelMapper.map(dtoPic, Picture.class);

            this.pictureRepository.saveAndFlush(picture);
            stringBuilder.append(String.format("Successfully imported picture - %s", picture.getUrl()))
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(PICTURES_SEED_PATH));
    }

    @Override
    public Long getPictureIdByUrl(String url) {
        Picture picture = this.pictureRepository.findByUrl(url).orElse(null);

        return picture == null ? null : picture.getId();
    }
}
