package com.davacom.Jobberlandapp.job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();

    String createNewJob(Job job);

    Job getJob(Long id);

    String deleteJob(Long id);

    Job updateJob(Long id, String tittle, String location);

    boolean deleteJob2(Long id);
}
