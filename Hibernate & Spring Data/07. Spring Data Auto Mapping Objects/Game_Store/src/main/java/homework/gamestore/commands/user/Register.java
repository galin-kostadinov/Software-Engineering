package homework.gamestore.commands.user;

import homework.gamestore.commands.Command;
import homework.gamestore.domain.dtos.UserRegisterDto;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public class Register extends Command {
    private static final int EMAIL_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;
    private static final int PASSWORD_CONFIRM_INDEX = 2;
    private static final int USER_NAME_INDEX = 3;

    public Register(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        UserRegisterDto userRegisterDto = new UserRegisterDto(
                args[EMAIL_INDEX],
                args[PASSWORD_INDEX],
                args[PASSWORD_CONFIRM_INDEX],
                args[USER_NAME_INDEX]);

        return this.getUserService().registerUser(userRegisterDto);
    }
}
