package homework.cardealer.web.controller;

import com.google.gson.Gson;
import homework.cardealer.constant.PathConstant;
import homework.cardealer.domain.dto.seed.CarSeedDto;
import homework.cardealer.domain.dto.seed.CustomerSeedDto;
import homework.cardealer.domain.dto.seed.PartSeedDto;
import homework.cardealer.domain.dto.seed.SupplierSeedDto;
import homework.cardealer.domain.dto.view.*;
import homework.cardealer.service.*;
import homework.cardealer.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class CarDealerController implements CommandLineRunner {
    private static final String REPORT = "::The report was successfully exported: ";
    private static final String WAIT = "!NB:::Some of the procedures will take more time. Please, wait several seconds.:::";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final FileUtil fileUtil;
    private final Gson gson;

    @Autowired
    public CarDealerController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, FileUtil fileUtil, Gson gson) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.fileUtil = fileUtil;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println(WAIT);
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

    private void seedData() throws IOException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }

    private void seedSuppliers() throws IOException {
        SupplierSeedDto[] dtos =
                this.gson.fromJson(new FileReader(PathConstant.SUPPLIERS_FILE_PATH), SupplierSeedDto[].class);

        this.supplierService.seedSuppliers(dtos);
    }

    private void seedParts() throws FileNotFoundException {
        PartSeedDto[] dtos =
                this.gson.fromJson(new FileReader(PathConstant.PARTS_FILE_PATH), PartSeedDto[].class);

        this.partService.seedParts(dtos);
    }

    private void seedCars() throws FileNotFoundException {
        CarSeedDto[] dtos =
                this.gson.fromJson(new FileReader(PathConstant.CARS_FILE_PATH), CarSeedDto[].class);

        this.carService.seedCars(dtos);
    }

    private void seedCustomers() throws FileNotFoundException {
        CustomerSeedDto[] dtos =
                this.gson.fromJson(new FileReader(PathConstant.CUSTOMERS_FILE_PATH), CustomerSeedDto[].class);

        this.customerService.seedCustomers(dtos);
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    private void getAllCustomersInOrdered() throws IOException {
        List<CustomerIdNameBDIsYoungerDriverViewDto> dtos = this.customerService.getOrderedCustomers();

        String content = this.gson.toJson(dtos);
        fileUtil.write(content, PathConstant.ORDERED_CUSTOMERS_FILE_PATH);
    }

    private void getAllCarsMakeToyota() throws IOException {
        List<CarIdMakeModelTravelledDistanceViewDto> dtos = this.carService.getAllCarsMakeToyota();

        String content = this.gson.toJson(dtos);
        fileUtil.write(content, PathConstant.CARS_MAKE_TOYOTA_FILE_PATH);
    }

    private void getAllLocalSuppliers() throws IOException {
        List<SupplierIdNamePartsCountViewDto> dtos = this.supplierService.getAllLocalSuppliers();

        String content = this.gson.toJson(dtos);
        fileUtil.write(content, PathConstant.LOCAL_SUPPLIER_FILE_PATH);
    }

    private void getAllCarsWithListedParts() throws IOException {
        List<CarWithPartsViewDto> dtos = this.carService.getAllCarsWithListedParts();

        String content = this.gson.toJson(dtos);
        fileUtil.write(content, PathConstant.CARS_WITH_PARTS_FILE_PATH);
    }

    private void getAllTotalSalesByCustomer() throws IOException {
        List<CustomerNameBoughtCarsSpendMoneyViewDto> dtos = this.customerService.getAllTotalSalesByCustomer();

        String content = this.gson.toJson(dtos);
        fileUtil.write(content, PathConstant.TOTAL_SALES_BY_CUSTOMER);
    }

    private void getAllSalesWithAppliedDiscount() throws IOException {
        List<SaleWithCarCustomerDiscountPrice> dtos = this.saleService.getAllTotalSalesByCustomer();

        String content = this.gson.toJson(dtos);
        fileUtil.write(content, PathConstant.SALES_WITH_APPLIED_DISCOUNT);
    }
}
