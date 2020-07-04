package exam.web;

import exam.model.view.ProductViewModel;
import exam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public HomeController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView getIndex(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("username") == null) {
            modelAndView.setViewName("index");
        } else {
            List<ProductViewModel> foods = productService.getFoods()
                    .stream()
                    .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                    .collect(Collectors.toList());
            modelAndView.addObject("foods", foods);

            List<ProductViewModel> drinks = productService.getDrinks()
                    .stream()
                    .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                    .collect(Collectors.toList());
            modelAndView.addObject("drinks", drinks);

            List<ProductViewModel> households = productService.getHouseholds()
                    .stream()
                    .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                    .collect(Collectors.toList());
            modelAndView.addObject("households", households);

            List<ProductViewModel> others = productService.getOthers()
                    .stream()
                    .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                    .collect(Collectors.toList());
            modelAndView.addObject("others", others);

            BigDecimal foodsSum = foods.stream().map(ProductViewModel::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal drinksSum = drinks.stream().map(ProductViewModel::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal householdsSum = households.stream().map(ProductViewModel::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal othersSum = others.stream().map(ProductViewModel::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal total = foodsSum.add(drinksSum).add(householdsSum).add(othersSum);

            modelAndView.addObject("total", total);

            modelAndView.setViewName("home");
        }

        return modelAndView;
    }
}
