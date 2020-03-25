package alararestaurant.service;

import alararestaurant.constant.GlobalConstants;
import alararestaurant.domain.dtos.seed.ItemSeedJsonDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static alararestaurant.constant.GlobalConstants.ITEMS_SEED_PATH;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
    }

    @Override
    public Boolean itemsAreImported() {
        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() throws IOException {
        return this.fileUtil.readFile(GlobalConstants.ITEMS_SEED_PATH);
    }

    @Override
    public String importItems(String items) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        ItemSeedJsonDto[] itemSeedDtos =
                this.gson.fromJson(new FileReader(ITEMS_SEED_PATH), ItemSeedJsonDto[].class);

        for (ItemSeedJsonDto itemSeedDto : itemSeedDtos) {
            if (itemSeedDto.getName() != null &&
                    this.itemRepository.findByName(itemSeedDto.getName()).orElse(null) != null) {
                sb.append("Invalid data format.").append(System.lineSeparator());
                continue;
            }

            if (!this.validationUtil.isValid(itemSeedDto)) {
                sb.append("Invalid data format.").append(System.lineSeparator());
                continue;
            }

            Category category = this.categoryService.getCategoryByName(itemSeedDto.getCategory());

            Item item = this.modelMapper.map(itemSeedDto, Item.class);

            item.setCategory(category);

            this.itemRepository.saveAndFlush(item);

            sb.append(String.format("Record %s successfully imported.", item.getName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public Item getByName(String name) {
        return this.itemRepository.findByName(name).orElse(null);
    }
}
