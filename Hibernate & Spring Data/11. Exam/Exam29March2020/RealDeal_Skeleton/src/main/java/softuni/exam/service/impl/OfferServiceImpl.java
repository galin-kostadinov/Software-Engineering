package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.Constant.GlobalConstants;
import softuni.exam.models.dto.seed.xml.OfferSeedDto;
import softuni.exam.models.dto.seed.xml.OfferSeedRootDto;
import softuni.exam.models.dto.seed.xml.SellerSeedDto;
import softuni.exam.models.dto.seed.xml.SellersSeedRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static softuni.exam.Constant.GlobalConstants.*;
import static softuni.exam.Constant.GlobalConstants.SELLERS_SEED_PATH;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final CarService carService;
    private final SellerService sellerService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    private final FileIOUtil fileIOUtil;

    public OfferServiceImpl(OfferRepository offerRepository, CarService carService,
                            SellerService sellerService, ValidationUtil validationUtil,
                            ModelMapper modelMapper, XmlParser xmlParser, FileIOUtil fileIOUtil) {
        this.offerRepository = offerRepository;
        this.carService = carService;
        this.sellerService = sellerService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.fileIOUtil = fileIOUtil;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return fileIOUtil.readFileContent(OFFERS_SEED_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        OfferSeedRootDto offerSeedRootDto =
                xmlParser.objectFromFile(OfferSeedRootDto.class, OFFERS_SEED_PATH);

        for (OfferSeedDto offerSeedDto : offerSeedRootDto.getOffers()) {
            if (!validationUtil.isValid(offerSeedDto)) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Offer offerInDb = offerRepository
                    .findByDescriptionAndAddedOn(offerSeedDto.getDescription(), offerSeedDto.getAddedOn());

            if (offerInDb != null) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Car car = carService.getCarById(offerSeedDto.getCar().getId());

            if (car == null) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Seller seller = sellerService.getSellerById(offerSeedDto.getSeller().getId());

            if (seller == null) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Offer offer = this.modelMapper.map(offerSeedDto, Offer.class);
            offer.setCar(car);
            offer.setSeller(seller);
            offer.setPictures(car.getPictures());

            this.offerRepository.saveAndFlush(offer);

            sb.append(String.format("Successfully import offer %s - %s", offer.getAddedOn(), offer.getHasGoldStatus()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
