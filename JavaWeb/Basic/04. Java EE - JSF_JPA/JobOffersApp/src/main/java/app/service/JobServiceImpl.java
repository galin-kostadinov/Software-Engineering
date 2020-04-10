package app.service;

import app.domain.entity.JobApplication;
import app.domain.model.service.JobApplicationServiceModel;
import app.repository.JobApplicationRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobServiceImpl implements JobService {
    private final JobApplicationRepository jobApplicationRepo;
    private final ModelMapper modelMapper;

    @Inject
    public JobServiceImpl(JobApplicationRepository jobApplicationRepo, ModelMapper modelMapper) {
        this.jobApplicationRepo = jobApplicationRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(JobApplicationServiceModel job) {
        this.jobApplicationRepo.save(this.modelMapper.map(job, JobApplication.class));
    }

    @Override
    public List<JobApplicationServiceModel> getAll() {
        return this.jobApplicationRepo.findAll()
                .stream()
                .map(j -> modelMapper.map(j, JobApplicationServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobApplicationServiceModel getById(String id) {
        return this.modelMapper.map(this.jobApplicationRepo.findById(id), JobApplicationServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.jobApplicationRepo.delete(id);
    }
}
