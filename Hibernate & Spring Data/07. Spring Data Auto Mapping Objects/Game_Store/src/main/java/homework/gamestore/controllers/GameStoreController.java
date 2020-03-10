package homework.gamestore.controllers;

import homework.gamestore.commands.*;
import homework.gamestore.commands.game.AddGame;
import homework.gamestore.commands.game.DeleteGame;
import homework.gamestore.commands.game.EditGame;
import homework.gamestore.commands.shop.AddItem;
import homework.gamestore.commands.shop.BuyItem;
import homework.gamestore.commands.shop.RemoveItem;
import homework.gamestore.commands.user.Login;
import homework.gamestore.commands.user.Logout;
import homework.gamestore.commands.user.Register;
import homework.gamestore.commands.view.AllGames;
import homework.gamestore.commands.view.DetailGame;
import homework.gamestore.commands.view.OwnedGames;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.Arrays;

import static homework.gamestore.constants.CommandConstants.*;

@Component
public class GameStoreController implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;
    private final BufferedReader br;

    @Autowired
    public GameStoreController(UserService userService, GameService gameService, BufferedReader br) {
        this.userService = userService;
        this.gameService = gameService;
        this.br = br;
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Commands format:");
            System.out.println("RegisterUser|<email>|<password>|<confirmPassword>|<fullName>");
            System.out.println("LoginUser|<email>|<password>");
            System.out.println("Logout");
            System.out.println("AddGame|<title>|<price>|<size>|<trailer>|<thubnailURL>|<description>|<releaseDate>");
            System.out.println("EditGame|<id>|<values>");
            System.out.println("AllGames");
            System.out.println("DetailsGame|<gameTitle>");
            System.out.println("OwnedGames");
            System.out.println("AddItem|<gameTitle>");
            System.out.println("RemoveItem|<gameTitle>");
            System.out.println("BuyItem");
            System.out.println("-----------------------------------------------------------------------------------");

            System.out.println("Please, Enter the command:");

            String[] params = br.readLine().split("\\|");

            Command command = null;
            switch (params[0]) {
                case REGISTER_USER:
                    command = new Register(userService, gameService);
                    break;
                case LOGIN_USER:
                    command = new Login(userService, gameService);
                    break;
                case LOGOUT_USER:
                    command = new Logout(userService, gameService);
                    break;
                case ADD_GAME:
                    command = new AddGame(userService, gameService);
                    break;
                case EDIT_GAME:
                    command = new EditGame(userService, gameService);
                    break;
                case DELETE_GAME:
                    command = new DeleteGame(userService, gameService);
                    break;
                case ALL_GAME:
                    command = new AllGames(userService, gameService);
                    break;
                case DETAIL_GAME:
                    command = new DetailGame(userService, gameService);
                    break;
                case OWNED_GAME:
                    command = new OwnedGames(userService, gameService);
                    break;
                case ADD_ITEM:
                    command = new AddItem(userService, gameService);
                    break;
                case REMOVE_ITEM:
                    command = new RemoveItem(userService, gameService);
                    break;
                case BUY_ITEM:
                    command = new BuyItem(userService, gameService);
                    break;
                default:
                    System.out.println("The entered command format is not appropriate. Please, try again.");
                    break;
            }

            if (command == null) {
                continue;
            }

            params = Arrays.copyOfRange(params, 1, params.length);

            System.out.println(command.execute(params));
        }
    }
}
