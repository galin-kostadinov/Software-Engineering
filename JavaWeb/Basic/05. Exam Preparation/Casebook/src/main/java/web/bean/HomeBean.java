package web.bean;

import domain.model.service.UserServiceModel;
import domain.model.view.HomeViewModel;
import org.modelmapper.ModelMapper;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean extends BaseBean {

    private List<HomeViewModel> models;
    private UserService userService;
    private ModelMapper modelMapper;

    public HomeBean() {
    }

    @Inject
    public HomeBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        String username = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false)).getAttribute("username").toString();

        this.models = this.userService.getAll()
                .stream()
                .filter(u -> !u.getUsername().equals(username) &&
                        !u.getFriends().stream()
                                .map(UserServiceModel::getUsername)
                                .collect(Collectors.toList()).contains(username))
                .map(u -> this.modelMapper.map(u, HomeViewModel.class))
                .collect(Collectors.toList());
    }

    public void addFriend(String friendId) {
        String id = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false)).getAttribute("userId").toString();

        UserServiceModel loggedIn = this.userService.getById(id);
        UserServiceModel friend = this.userService.getById(friendId);

        loggedIn.getFriends().add(friend);
        friend.getFriends().add(loggedIn);

        this.userService.addFriend(loggedIn);
        this.userService.addFriend(friend);

        this.redirect("/home");
    }

    public List<HomeViewModel> getModels() {
        return models;
    }

    public void setModels(List<HomeViewModel> models) {
        this.models = models;
    }
}
