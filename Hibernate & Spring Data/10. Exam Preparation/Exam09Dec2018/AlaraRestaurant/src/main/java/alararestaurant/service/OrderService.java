package alararestaurant.service;

import java.io.IOException;

public interface OrderService {

    Boolean ordersAreImported();

    String readOrdersXmlFile() throws IOException;

    String importOrders();

    String exportOrdersFinishedByTheBurgerFlippers();
}
