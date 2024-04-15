package com.davacom.Jobberlandapp.job.serviceImpl;

import com.davacom.Jobberlandapp.job.Job;
import com.davacom.Jobberlandapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceIml implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Job> getAllJobs() {
        return jobs;
    }

    @Override
    public String createNewJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
        return "Job added successfully";
    }

    @Override
    public Job getJob(Long id) {
        for (Job job: jobs) {
            if(Objects.equals(job.getId(), id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public String deleteJob(Long id) {
        for (Job job: jobs) {
            if(Objects.equals(job.getId(), id)){
                jobs.remove(job);
                return "Job deleted Successfully";
            }
        }
        return "Job not found";
    }

    @Override
    public Job updateJob(Long id, String tittle, String location) {
        for (Job job: jobs) {
            if(Objects.equals(job.getId(), id)){
                jobs.remove(job);
                job.setTittle(tittle);
                job.setLocation(location);
                jobs.add(job);
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJob2(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if(job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

