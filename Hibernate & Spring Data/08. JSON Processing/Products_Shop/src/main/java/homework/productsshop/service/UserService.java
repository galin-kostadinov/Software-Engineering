package homework.productsshop.service;

import homework.productsshop.domain.dto.UsersCountWithProductsDto;
import homework.productsshop.domain.dto.seed.UserSeedDto;
import homework.productsshop.domain.dto.UserSoldProductsDto;

import java.util.List;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);

    List<UserSoldProductsDto> getAllUsersWithSoldProducts();

    UsersCountWithProductsDto getUsersCountWithSoldProducts();
}
