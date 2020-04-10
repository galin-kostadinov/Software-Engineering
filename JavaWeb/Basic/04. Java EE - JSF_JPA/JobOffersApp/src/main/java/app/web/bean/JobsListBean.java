package app.web.bean;

import app.domain.model.view.JobViewModel;
import app.service.JobService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class JobsListBean extends BaseBean {

    private List<JobViewModel> jobs;
    private JobService jobService;
    private ModelMapper modelMapper;

    public JobsListBean() {
    }

    @Inject
    public JobsListBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.setJobs(this.jobService.getAll().stream()
                .map(j -> {
                            JobViewModel job = this.modelMapper.map(j, JobViewModel.class);
                            job.setSector(j.getSector().toString().toLowerCase());
                            return job;
                        }
                )
                .collect(Collectors.toList())
        );
    }

    public List<JobViewModel> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobViewModel> jobs) {
        this.jobs = jobs;
    }
}
