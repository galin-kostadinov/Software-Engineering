package exam.web;

import exam.model.binding.UserLoginBindingModel;
import exam.model.binding.UserRegisterBindingModel;
import exam.model.service.UserLoginServiceModel;
import exam.model.service.UserRegisterServiceModel;
import exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "redirect:/";
        }

        if (model.getAttribute("userRegisterBindingModel") == null) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (userRegisterBindingModel == null || bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "redirect:/";
        }

        if (model.getAttribute("userLoginBindingModel") == null) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFoundUser", false);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session) {

        if (userLoginBindingModel == null || bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        if (!this.userService.login(this.modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class))) {
            redirectAttributes.addAttribute("notFoundUser", true);
            return "redirect:login";
        }

        session.setAttribute("username", userLoginBindingModel.getUsername());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }

        session.invalidate();
        return "redirect:login";
    }
}
