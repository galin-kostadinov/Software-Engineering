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
public class FriendsBean extends BaseBean {
    private List<HomeViewModel> friends;
    private UserService userService;
    private ModelMapper modelMapper;

    public FriendsBean() {
    }

    @Inject
    public FriendsBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        String id = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false)).getAttribute("userId").toString();

        this.friends = this.userService.getById(id).getFriends()
                .stream()
                .map(f -> modelMapper.map(f, HomeViewModel.class))
                .collect(Collectors.toList());
    }

    public void unfriend(String friendId) {
        String id = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false)).getAttribute("userId").toString();

        UserServiceModel loggedIn = this.userService.getById(id);
        UserServiceModel friend = this.userService.getById(friendId);

        loggedIn.getFriends().remove(friend);
        friend.getFriends().remove(loggedIn);

        this.userService.removeFriend(loggedIn);
        this.userService.removeFriend(friend);

        this.redirect("/friends");
    }

    public List<HomeViewModel> getFriends() {
        return friends;
    }

    public void setFriends(List<HomeViewModel> friends) {
        this.friends = friends;
    }
}
