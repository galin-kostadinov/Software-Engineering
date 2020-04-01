package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.seed.json.PictureSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static softuni.exam.Constant.GlobalConstants.*;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final CarService carService;
    private final FileIOUtil fileIOUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public PictureServiceImpl(PictureRepository pictureRepository, CarService carService, FileIOUtil fileIOUtil, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.carService = carService;
        this.fileIOUtil = fileIOUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return fileIOUtil.readFileContent(PICTURES_SEED_PATH);
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        PictureSeedDto[] pictureSeedDtos =
                gson.fromJson(fileIOUtil.readFileContent(PICTURES_SEED_PATH), PictureSeedDto[].class);

        for (PictureSeedDto pictureSeedDto : pictureSeedDtos) {
            if (!validationUtil.isValid(pictureSeedDto)) {
                sb.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            Picture picInDb = pictureRepository
                    .findByName(pictureSeedDto.getName());

            if (picInDb != null) {
                sb.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            Car car = carService.getCarById(pictureSeedDto.getCar());

            if (car == null) {
                sb.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            Picture picture = this.modelMapper.map(pictureSeedDto, Picture.class);

            LocalDateTime dateAndTime = LocalDateTime.parse(pictureSeedDto.getDateAndTime(), DATE_TIME_FORMAT);

            picture.setDateAndTime(dateAndTime);
            picture.setCar(car);

            picture.setDateAndTime(dateAndTime);

            this.pictureRepository.saveAndFlush(picture);

            sb.append(String.format("Successfully import picture - %s", picture.getName()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
