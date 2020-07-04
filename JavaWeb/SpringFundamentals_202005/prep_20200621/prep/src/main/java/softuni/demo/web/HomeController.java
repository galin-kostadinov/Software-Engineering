package softuni.demo.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.demo.model.view.ItemViewModel;
import softuni.demo.service.ItemService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public HomeController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView getIndex(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("username") == null) {
            modelAndView.setViewName("index");
        } else {
            List<ItemViewModel> items = itemService.getAllItems()
                    .stream()
                    .map(item -> {
                        ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
                        itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory()));
                        return itemViewModel;
                    })
                    .collect(Collectors.toList());
            modelAndView.addObject("items", items);
            modelAndView.setViewName("home");
        }

        return modelAndView;
    }
}
