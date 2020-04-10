package app.web.bean;

import app.domain.model.view.JobViewModel;
import app.service.JobService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class DetailsBean {
    private JobService jobService;
    private ModelMapper modelMapper;

    public DetailsBean() {
    }

    @Inject
    public DetailsBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    public JobViewModel getJobById(String id) {
        JobViewModel job = this.modelMapper.map(this.jobService.getById(id), JobViewModel.class);
        job.setSector(job.getSector().substring(0, 1) + job.getSector().substring(1).toLowerCase());
        return job;
    }
}
