package homework.productsshop.service;

import homework.productsshop.domain.dto.seed.UserSeedDto;
import homework.productsshop.domain.dto.view.UserSoldProductsViewRootDto;
import homework.productsshop.domain.dto.view.UsersCountWithProductsViewRootDto;

import java.util.List;

public interface UserService {

    void seedUsers(List<UserSeedDto> userSeedDtos);

    UserSoldProductsViewRootDto getAllUsersWithSoldProducts();

    UsersCountWithProductsViewRootDto getUsersCountWithSoldProducts();

}
