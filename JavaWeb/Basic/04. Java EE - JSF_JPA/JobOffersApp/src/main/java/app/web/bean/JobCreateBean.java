package app.web.bean;

import app.domain.entity.Sector;
import app.domain.model.binding.JobCreateBinding;
import app.domain.model.service.JobApplicationServiceModel;
import app.service.JobService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobCreateBean extends BaseBean {
    private JobCreateBinding jobCreateBinding;
    private JobService jobService;
    private ModelMapper modelMapper;

    public JobCreateBean() {
    }

    @Inject
    public JobCreateBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.jobCreateBinding = new JobCreateBinding();
    }

    public void create() {
        JobApplicationServiceModel serviceModel =
                this.modelMapper.map(this.jobCreateBinding, JobApplicationServiceModel.class);

        Sector sector;

        try {
            sector = Sector.valueOf(this.jobCreateBinding.getSector());
        } catch (Exception e) {
            this.redirect("/add-job");
            return;
        }

        serviceModel.setSector(sector);
        this.jobService.save(serviceModel);

        this.redirect("/home");
    }

    public JobCreateBinding getJobCreateBinding() {
        return jobCreateBinding;
    }

    public void setJobCreateBinding(JobCreateBinding jobCreateBinding) {
        this.jobCreateBinding = jobCreateBinding;
    }
}
