package alararestaurant.service;

import alararestaurant.domain.entities.Item;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ItemService {
    Boolean itemsAreImported();

    String readItemsJsonFile() throws IOException;

    String importItems(String items) throws FileNotFoundException;

    Item getByName(String name);
}
