package softuni.demo.service;

import softuni.demo.model.service.ItemServiceModel;
import softuni.demo.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {

    void addItem(ItemServiceModel itemServiceModel);

    ItemServiceModel getById(String id);

    List<ItemServiceModel> getAllItems();

    void delete(String id);
}
