package collectionHierarchy.impl;

import collectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String element) {
        super.getItems().add(0, element);
        return super.getItems().size() - 1;
    }
}
