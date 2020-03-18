package homework.cardealer.web.controller;

import homework.cardealer.constant.PathConstant;
import homework.cardealer.domain.dto.seed.*;
import homework.cardealer.domain.dto.view.*;
import homework.cardealer.service.*;
import homework.cardealer.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static homework.cardealer.constant.PathConstant.*;

@Component
public class CarDealerController implements CommandLineRunner {
    private static final String REPORT = "::The report was successfully exported: ";
    private static final String WAIT = "!NB:::Some of the procedures will take more time. Please, wait several seconds.:::";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final XmlParser xmlParser;

    @Autowired
    public CarDealerController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, XmlParser xmlParser) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------------------");
        System.out.println(WAIT);
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("Enter 0: 'Seed the Database'");
        System.out.println("Enter 1: 'Query 1 – Ordered Customers'");
        System.out.println("Enter 2: 'Query 2 – Cars from Make Toyota'");
        System.out.println("Enter 3: 'Query 3 – Local Suppliers'");
        System.out.println("Enter 4: 'Query 4 – Cars with Their List of Parts'");
        System.out.println("Enter 5: 'Query 5 – Total Sales by Customer'");
        System.out.println("Enter 6: 'Query 6 – Sales with Applied Discount'");
        System.out.println("Enter 9: EXIT");
        System.out.println("------------------------------------------");

        int choice;

        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("Please, enter your choice:");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 0:
                    this.seedData();
                    break;
                case 1:
                    getAllCustomersInOrdered();
                    System.out.println(REPORT + PathConstant.ORDERED_CUSTOMERS_FILE_PATH);
                    break;
                case 2:
                    getAllCarsMakeToyota();
                    System.out.println(REPORT + PathConstant.CARS_MAKE_TOYOTA_FILE_PATH);
                    break;
                case 3:
                    getAllLocalSuppliers();
                    System.out.println(REPORT + PathConstant.LOCAL_SUPPLIER_FILE_PATH);
                    break;
                case 4:
                    getAllCarsWithListedParts();
                    System.out.println(REPORT + PathConstant.CARS_WITH_PARTS_FILE_PATH);
                    break;
                case 5:
                    getAllTotalSalesByCustomer();
                    System.out.println(REPORT + PathConstant.TOTAL_SALES_BY_CUSTOMER);
                    break;
                case 6:
                    getAllSalesWithAppliedDiscount();
                    System.out.println(REPORT + PathConstant.SALES_WITH_APPLIED_DISCOUNT);
                    break;
                case 9:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Incorrect choice. Try again.");
                    break;
            }
        }
    }

    private void seedData() throws IOException, JAXBException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }

    private void seedSuppliers() throws IOException, JAXBException {
        SupplierSeedRootDto dtos = this.xmlParser.objectFromFile(SupplierSeedRootDto.class, SUPPLIERS_FILE_PATH);

        this.supplierService.seedSuppliers(dtos.getSupplierDto());
    }

    private void seedParts() throws FileNotFoundException {
        PartSeedRootDto dtos =
                this.xmlParser.objectFromFile(PartSeedRootDto.class, PARTS_FILE_PATH);

        this.partService.seedParts(dtos.getParts());
    }

    private void seedCars() throws FileNotFoundException {
        CarSeedRootDto dtos =
                this.xmlParser.objectFromFile(CarSeedRootDto.class, CARS_FILE_PATH);

        this.carService.seedCars(dtos.getCars());
    }

    private void seedCustomers() throws FileNotFoundException {
        CustomerSeedRoodDto dtos =
                this.xmlParser.objectFromFile(CustomerSeedRoodDto.class, CUSTOMERS_FILE_PATH);

        this.customerService.seedCustomers(dtos.getCustomers());
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    private void getAllCustomersInOrdered() throws IOException {
        CustomerViewRootDto dtos = this.customerService.getOrderedCustomers();

        this.xmlParser.objectToFile(dtos, ORDERED_CUSTOMERS_FILE_PATH);
    }

    private void getAllCarsMakeToyota() throws IOException {
        CarIdMakeModelTravelledDistanceViewRootDto dtos = this.carService.getAllCarsMakeToyota();

        this.xmlParser.objectToFile(dtos, CARS_MAKE_TOYOTA_FILE_PATH);
    }

    private void getAllLocalSuppliers() throws IOException {
        SupplierIdNamePartsCountViewRootDto dtos = this.supplierService.getAllLocalSuppliers();

        this.xmlParser.objectToFile(dtos, LOCAL_SUPPLIER_FILE_PATH);
    }

    private void getAllCarsWithListedParts() throws IOException {
        CarMakeModelTravelledDistanceViewRootDto dtos = this.carService.getAllCarsWithListedParts();

        this.xmlParser.objectToFile(dtos, CARS_WITH_PARTS_FILE_PATH);
    }

    private void getAllTotalSalesByCustomer() throws IOException {
        CustomerNameBoughtCarsSpendMoneyViewRootDto dtos = this.customerService.getAllTotalSalesByCustomer();

        this.xmlParser.objectToFile(dtos, TOTAL_SALES_BY_CUSTOMER);
    }

    private void getAllSalesWithAppliedDiscount() throws IOException {
        SaleWithCarCustomerDiscountPriceViewRootDto dtos = this.saleService.getAllTotalSalesByCustomer();

        this.xmlParser.objectToFile(dtos, SALES_WITH_APPLIED_DISCOUNT);
    }
}
