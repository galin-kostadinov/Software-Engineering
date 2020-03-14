package homework.productsshop.service;

import homework.productsshop.domain.dto.*;
import homework.productsshop.domain.dto.seed.UserSeedDto;
import homework.productsshop.domain.entity.Product;
import homework.productsshop.domain.entity.User;
import homework.productsshop.repository.UserRepository;
import homework.productsshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ValidatorUtil validatorUtil, ModelMapper modelMapper, UserRepository userRepository) {
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!validatorUtil.isValid(userSeedDto)) {
                this.validatorUtil
                        .violations(userSeedDto)
                        .forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            User user = this.modelMapper.map(userSeedDto, User.class);
            this.userRepository.saveAndFlush(user);
        }
    }

    @Override
    public List<UserSoldProductsDto> getAllUsersWithSoldProducts() {
        List<User> sellerSoldProducts = this.userRepository.getAllWithSoldProducts();

        List<UserSoldProductsDto> userSoldProductsDtoList = new ArrayList<>();

        for (User seller : sellerSoldProducts) {
            UserSoldProductsDto userSoldProductsDto = modelMapper.map(seller, UserSoldProductsDto.class);

            for (Product sellProduct : seller.getSellProducts()) {
                if (sellProduct.getBuyer() != null) {
                    SoldProductsDto soldProductsDto = modelMapper.map(sellProduct, SoldProductsDto.class);
                    userSoldProductsDto.getSoldProducts().add(soldProductsDto);
                }
            }

            userSoldProductsDtoList.add(userSoldProductsDto);
        }

        return userSoldProductsDtoList;
    }

    @Override
    public UsersCountWithProductsDto getUsersCountWithSoldProducts() {
        List<User> usersProducts = this.userRepository.getAllWithSoldProducts();

        UsersCountWithProductsDto usersCountWithProductsDtos = new UsersCountWithProductsDto();

        for (User seller : usersProducts) {
            UserNameAgeSoldProductsDto userNameAgeSoldProductsDto = modelMapper.map(seller, UserNameAgeSoldProductsDto.class);

            SoldProductsCountNamePriceDto soldProductsCountNamePriceDto = new SoldProductsCountNamePriceDto();

            for (Product sellProduct : seller.getSellProducts()) {
                if (sellProduct.getBuyer() != null) {
                    ProductNamePriceDto productNamePriceDto = modelMapper.map(sellProduct, ProductNamePriceDto.class);
                    soldProductsCountNamePriceDto.getProducts().add(productNamePriceDto);
                }
            }

            soldProductsCountNamePriceDto.setCount((long) soldProductsCountNamePriceDto.getProducts().size());

            userNameAgeSoldProductsDto.setSoldProducts(soldProductsCountNamePriceDto);

            usersCountWithProductsDtos.getUsers().add(userNameAgeSoldProductsDto);
        }

        usersCountWithProductsDtos.setUsersCount((long) usersCountWithProductsDtos.getUsers().size());

        usersCountWithProductsDtos.setUsers(
                usersCountWithProductsDtos.getUsers()
                        .stream()
                        .sorted((dto1, dto2) -> {
                            int sort = Long.compare(dto2.getSoldProducts().getCount(), dto1.getSoldProducts().getCount());

                            if (sort == 0) {
                                sort = dto1.getLastName().compareTo(dto2.getLastName());
                            }
                            return sort;
                        })
                        .collect(Collectors.toList())
        );

        return usersCountWithProductsDtos;
    }
}
