package app.service;

import app.domain.model.service.JobApplicationServiceModel;

import java.util.List;

public interface JobService {
    void save(JobApplicationServiceModel job);

    List<JobApplicationServiceModel> getAll();

    JobApplicationServiceModel getById(String id);

    void delete (String id);
}
