package softuni.demo.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.demo.model.binding.ItemAddBindingModel;
import softuni.demo.model.service.ItemServiceModel;
import softuni.demo.model.view.ItemViewModel;
import softuni.demo.service.ItemService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }

        if (model.getAttribute("itemAddBindingModel") == null) {
            model.addAttribute("itemAddBindingModel", new ItemAddBindingModel());
        }

        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }

        if (itemAddBindingModel == null || bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:add";
        }

        this.itemService.addItem(this.modelMapper.map(itemAddBindingModel, ItemServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") String id, ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("username") == null) {
            modelAndView.setViewName("redirect:/users/login");
        }

        ItemViewModel item = this.modelMapper.map(this.itemService.getById(id), ItemViewModel.class);
        item.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory()));

        modelAndView.addObject("item", item);
        modelAndView.setViewName("details-item");
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }

        this.itemService.delete(id);

        return "redirect:/";
    }
}
