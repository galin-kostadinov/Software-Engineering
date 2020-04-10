package app.web.bean;

import app.domain.model.view.JobViewModel;
import app.service.JobService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class DeleteBean extends BaseBean {
    private JobService jobService;
    private ModelMapper modelMapper;

    public DeleteBean() {
    }

    @Inject
    public DeleteBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    public JobViewModel getJobById(String id) {
        return this.modelMapper.map(this.jobService.getById(id), JobViewModel.class);
    }

    public void delete() {
        String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.jobService.delete(id);
        this.redirect("/home");
    }
}
