package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.Constant.GlobalConstants;
import softuni.exam.models.dto.seed.json.PictureSeedDto;
import softuni.exam.models.dto.seed.xml.SellerSeedDto;
import softuni.exam.models.dto.seed.xml.SellersSeedRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;

import static softuni.exam.Constant.GlobalConstants.*;
import static softuni.exam.Constant.GlobalConstants.PICTURES_SEED_PATH;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final FileIOUtil fileIOUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public SellerServiceImpl(SellerRepository sellerRepository, FileIOUtil fileIOUtil, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.fileIOUtil = fileIOUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return fileIOUtil.readFileContent(SELLERS_SEED_PATH);
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        SellersSeedRootDto sellersSeedRootDtos =
                xmlParser.objectFromFile(SellersSeedRootDto.class, SELLERS_SEED_PATH);

        for (SellerSeedDto sellersSeedDto : sellersSeedRootDtos.getSellers()) {
            if (!validationUtil.isValid(sellersSeedDto)) {
                sb.append("Invalid seller").append(System.lineSeparator());
                continue;
            }

            Seller sellerInDb = sellerRepository
                    .findByEmail(sellersSeedDto.getEmail());

            if (sellerInDb != null) {
                sb.append("Invalid seller").append(System.lineSeparator());
                continue;
            }

            Seller seller = this.modelMapper.map(sellersSeedDto, Seller.class);

            this.sellerRepository.saveAndFlush(seller);

            sb.append(String.format("Successfully import seller %s - %s", seller.getLastName(), seller.getEmail()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }
}
