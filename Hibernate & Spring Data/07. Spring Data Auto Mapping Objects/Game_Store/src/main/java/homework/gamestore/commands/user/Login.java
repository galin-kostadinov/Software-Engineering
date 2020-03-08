package homework.gamestore.commands.user;

import homework.gamestore.commands.Command;
import homework.gamestore.domain.dtos.UserLoginDto;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public class Login extends Command {
    private static final int EMAIL_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;

    public Login(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        UserLoginDto userLoginDto = new UserLoginDto(args[EMAIL_INDEX], args[PASSWORD_INDEX]);
        String messageLogin = this.getUserService().loginUser(userLoginDto);

        if (messageLogin.contains("Successfully logged in")) {
            this.getGameService().setLoggedInUser(userLoginDto.getEmail());
        }

        return messageLogin;
    }
}
