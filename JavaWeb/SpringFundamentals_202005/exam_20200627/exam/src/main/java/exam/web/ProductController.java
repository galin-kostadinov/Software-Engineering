package exam.web;

import exam.model.binding.ProductAddBindingModel;
import exam.model.service.ProductServiceModel;
import exam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }

        if (model.getAttribute("productAddBindingModel") == null) {
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
        }

        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }

        if (productAddBindingModel == null || bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";
        }

        this.productService.addProduct(this.modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/buy/{id}")
    public String buy(@PathVariable("id") String id, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }

        this.productService.buyProduct(id);

        return "redirect:/";
    }

    @GetMapping("/buy-all")
    public String buyAll(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }

        this.productService.buyAll();

        return "redirect:/";
    }


}
