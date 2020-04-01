package hiberspring.service;

import hiberspring.common.Constants;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.domain.dto.seed.xml.ProductSeedDto;
import hiberspring.domain.dto.seed.xml.ProductSeedRootDto;
import hiberspring.repository.ProductRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BranchService branchService;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BranchService branchService, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.productRepository = productRepository;
        this.branchService = branchService;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return fileUtil.readFile(Constants.PRODUCTS_SEED_PATH);
    }

    @Override
    public String importProducts() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        ProductSeedRootDto productSeedRootDto =
                this.xmlParser.parseXml(ProductSeedRootDto.class, Constants.PRODUCTS_SEED_PATH);

        for (ProductSeedDto productSeedDto : productSeedRootDto.getProducts()) {
            if (!this.validationUtil.isValid(productSeedDto)) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Branch branch = this.branchService.getBranchByName(productSeedDto.getBranch());

            if (branch == null) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Product product = this.modelMapper.map(productSeedDto, Product.class);
            product.setBranch(branch);

            this.productRepository.saveAndFlush(product);

            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, "Product", product.getName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
