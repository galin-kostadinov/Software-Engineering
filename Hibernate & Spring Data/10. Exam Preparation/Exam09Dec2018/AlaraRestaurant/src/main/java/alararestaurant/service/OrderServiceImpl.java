package alararestaurant.service;

import alararestaurant.adaptor.LocalDateTimeAdaptor;
import alararestaurant.constant.GlobalConstants;
import alararestaurant.domain.dtos.seed.ItemSeedXmlDto;
import alararestaurant.domain.dtos.seed.OrderSeedDto;
import alararestaurant.domain.dtos.seed.OrderSeedRootDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Item;
import alararestaurant.domain.entities.Order;
import alararestaurant.domain.entities.OrderItem;
import alararestaurant.repository.OrderRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import alararestaurant.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static alararestaurant.constant.GlobalConstants.ORDERS_SEED_PATH;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final EmployeeService employeeService;
    private final OrderItemService orderItemService;
    private final ItemService itemService;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final LocalDateTimeAdaptor localDateTimeAdaptor;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, EmployeeService employeeService, OrderItemService orderItemService, ItemService itemService, FileUtil fileUtil, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, LocalDateTimeAdaptor localDateTimeAdaptor) {

        this.orderRepository = orderRepository;
        this.employeeService = employeeService;
        this.orderItemService = orderItemService;
        this.itemService = itemService;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.localDateTimeAdaptor = localDateTimeAdaptor;
    }

    @Override
    public Boolean ordersAreImported() {
        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {
        return this.fileUtil.readFile(GlobalConstants.ORDERS_SEED_PATH);
    }

    @Override
    public String importOrders() {
        StringBuilder sb = new StringBuilder();

        OrderSeedRootDto orderSeedRootDto =
                this.xmlParser.objectFromFile(OrderSeedRootDto.class, ORDERS_SEED_PATH);

        for (OrderSeedDto orderSeedDto : orderSeedRootDto.getOrders()) {
            Employee employee = this.employeeService.getEmployeeByName(orderSeedDto.getEmployee());

            if (employee == null) {
                continue;
            }

            List<ItemSeedXmlDto> itemSeedXmlDtos = orderSeedDto.getItems().getItems();
            List<Item> items = new ArrayList<>();

            for (ItemSeedXmlDto itemSeedXmlDto : itemSeedXmlDtos) {
                Item item = this.itemService.getByName(itemSeedXmlDto.getName());

                if (item == null) {
                    break;
                }

                items.add(item);
            }

            if (itemSeedXmlDtos.size() != items.size()) {
                continue;
            }

            if (!this.validationUtil.isValid(orderSeedDto)) {
                continue;
            }

            Order order = this.modelMapper.map(orderSeedDto, Order.class);
            order.setEmployee(employee);
            order.getOrderItems().clear();

            this.orderRepository.saveAndFlush(order);

            int index = 0;
            for (ItemSeedXmlDto itemSeedXmlDto : itemSeedXmlDtos) {
                OrderItem orderItem = new OrderItem(order, items.get(index), itemSeedXmlDto.getQuantity());
                this.orderItemService.saveOrderItem(orderItem);

                index++;
            }

            sb.append(String.format("Order for %s on %s added",
                    order.getCustomer(),
                    this.localDateTimeAdaptor.marshal(order.getDateTime())))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        List<Order> orders = this.orderRepository
                .findByEmployeePositionNameOrderByEmployeeNameAndOrderId();

        StringBuilder sb = new StringBuilder();

        orders.forEach(o -> {
            sb.append(String.format("Name: %s", o.getEmployee().getName())).append(System.lineSeparator());
            sb.append("Orders:").append(System.lineSeparator());
            sb.append(String.format("   Customer: %s", o.getCustomer())).append(System.lineSeparator());
            sb.append("   Items:").append(System.lineSeparator());
            o.getOrderItems().forEach(oi -> {
                        sb.append(String.format("      Name: %s", oi.getItem().getName())).append(System.lineSeparator());
                        sb.append(String.format("      Price: %s", oi.getItem().getPrice())).append(System.lineSeparator());
                        sb.append(String.format("      Quantity: %s", oi.getQuantity())).append(System.lineSeparator());
                        sb.append(System.lineSeparator());
                    }
            );
        });

        return sb.toString().trim();
    }
}
