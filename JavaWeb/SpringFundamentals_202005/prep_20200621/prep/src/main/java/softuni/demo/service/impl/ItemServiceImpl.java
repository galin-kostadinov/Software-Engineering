package softuni.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.demo.data.ItemRepository;
import softuni.demo.model.entity.Category;
import softuni.demo.model.entity.Item;
import softuni.demo.model.service.ItemServiceModel;
import softuni.demo.service.CategoryService;
import softuni.demo.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        Item item = this.modelMapper.map(itemServiceModel, Item.class);
        Category category = categoryService.getCategoryByName(itemServiceModel.getCategory());
        item.setCategory(category);
        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public ItemServiceModel getById(String id) {
        Item item = itemRepository.findById(id).orElse(null);
        return this.modelMapper.map(item, ItemServiceModel.class);
    }

    @Override
    public List<ItemServiceModel> getAllItems() {
        return this.itemRepository
                .findAll()
                .stream()
                .map(item -> {
                    ItemServiceModel itemServiceModel = this.modelMapper.map(item, ItemServiceModel.class);
                    itemServiceModel.setCategory(item.getCategory().getCategory());
                    return itemServiceModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }
}
