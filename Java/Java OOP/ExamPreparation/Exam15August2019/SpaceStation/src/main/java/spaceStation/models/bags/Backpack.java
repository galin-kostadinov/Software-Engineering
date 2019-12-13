package spaceStation.models.bags;

import spaceStation.common.ConstantMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag {
    private List<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        return String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER,
                items.toString()
                        .replace("[", "")
                        .replace("]", ""));
    }
}
