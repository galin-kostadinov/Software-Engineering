package homework.usersystem.controller;

import homework.usersystem.entities.User;
import homework.usersystem.services.CountryService;
import homework.usersystem.services.TownService;
import homework.usersystem.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class AppController implements CommandLineRunner {
    private final UserService userService;
    private final TownService townService;
    private final CountryService countryService;

    public AppController(UserService userService, TownService townService, CountryService countryService) {
        this.userService = userService;
        this.townService = townService;
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.countryService.seedCountries();
        this.townService.seedTowns();

        int countOfUsers = 30;
        if (userService.getUsersCount() < countOfUsers) {
            this.addUsers(countOfUsers);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int choice;
        while (true) {
            printDashRow();
            System.out.println("Enter 1 to 'Get Users by Email Provider'");
            System.out.println("Enter 2 to 'Remove Inactive Users'");
            System.out.println("Enter 0 to Exit");
            printDashRow();
            System.out.println("Enter your choice:");

            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 0:
                    System.out.println("Buy");
                    return;
                case 1:
                    System.out.println("Enter Email Provider(example: abv.bg):");
                    String emailProvider = br.readLine();
                    printAllUsersByEmailProvider(emailProvider);
                    break;
                case 2:
                    System.out.println("Enter date(example '12 Oct 2004'):");
                    String dateAsString = br.readLine();
                    removeInactiveUsers(dateAsString);
                    break;
                default:
                    System.out.println("Incorrect choice. Try again.");
                    break;

            }
        }
    }

    private void removeInactiveUsers(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(strDate + " 00:00", formatter);

        userService.setToDeletedInactiveUsers(dateTime);

        long countOfIsDeleted = userService.deleteInactiveUsers();
        printDashRow();
        if (countOfIsDeleted > 0) System.out.printf("%d %s%n", countOfIsDeleted,
                countOfIsDeleted > 1 ? "users have been deleted" : "user has been deleted");
        else {
            System.out.println("No users have been deleted");
        }
        printDashRow();
    }

    private void printAllUsersByEmailProvider(String emailProvider) {
        List<String> users = this.userService
                .getUsersByEmailProvider(emailProvider);

        printDashRow();
        if (users.size() == 0) {
            System.out.printf("No users found with email domain %s%n", emailProvider);
        } else {
            users.forEach(System.out::println);
        }
        printDashRow();
    }

    private void addUsers(final int count) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy HH:mm");

        for (int i = 1; i <= count / 3; i++) {
            User user = new User();
            user.setUsername("username" + i);
            user.setPassword("pasSword%" + i);
            user.setEmail("mail" + i + "x@abv.bg");
            user.setAge(i % 120 + 1);
            user.setFirstName("First" + i);
            user.setLastName("Last" + i);
            int date = i + 1999;
            user.setRegisteredOn(LocalDateTime.parse("01 01 " + date + " 00:00", formatter));
            user.setLastTimeLoggedIn(LocalDateTime.parse("02 04 " + date + " 00:00", formatter));
            user.setIsDeleted(false);
            user.setBornTown(this.townService.getTownById(1L));
            user.setCurrentTown(this.townService.getTownById(1L));
            this.userService.save(user);
        }

        for (int i = count / 3; i <= (2 * count / 3); i++) {
            User user = new User();
            user.setUsername("username" + i);
            user.setPassword("pasSword%" + i);
            user.setEmail("mail" + i + "x@gmail.com");
            user.setAge(i % 120 + 1);
            user.setFirstName("First" + i);
            user.setLastName("Last" + i);
            int date = i + 1999;
            user.setRegisteredOn(LocalDateTime.parse("03 05 " + date + " 00:00", formatter));
            user.setLastTimeLoggedIn(LocalDateTime.parse("05 06 " + date + " 00:00", formatter));
            user.setIsDeleted(false);
            user.setBornTown(this.townService.getTownById(1L));
            user.setCurrentTown(this.townService.getTownById(1L));
            this.userService.save(user);
        }

        for (int i = (2 * count / 3); i <= count; i++) {
            User user = new User();
            user.setUsername("username" + i);
            user.setPassword("pasSword%" + i);
            user.setEmail("mail" + i + "x@yahoo.co.uk");
            user.setAge(i % 120 + 1);
            user.setFirstName("First" + i);
            user.setLastName("Last" + i);
            int date = i + 1999;
            user.setRegisteredOn(LocalDateTime.parse("02 04 " + date + " 00:00", formatter));
            user.setLastTimeLoggedIn(LocalDateTime.parse("03 08 " + date + " 00:00", formatter));
            user.setIsDeleted(false);
            user.setBornTown(this.townService.getTownById(1L));
            user.setCurrentTown(this.townService.getTownById(1L));
            this.userService.save(user);
        }
    }

    void printDashRow(){
        System.out.println("-----------------------------------------------------");
    }
}
