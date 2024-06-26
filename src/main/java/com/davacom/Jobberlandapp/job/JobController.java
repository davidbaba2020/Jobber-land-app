package com.davacom.Jobberlandapp.job;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postJob(@RequestBody Job  job) {
        return new ResponseEntity<>(jobService.createNewJob(job),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        if(jobService.getJob(id)!=null) {
            return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAJob(@PathVariable Long id) {
        String response = jobService.deleteJob(id);
        if(!Objects.equals(response, "Job not found!")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/2/{id}")
//    @RequestMapping(value = "/jobs2/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteAJobV2(@PathVariable Long id) {
        if(jobService.deleteJob2(id)){
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, String tittle, String location) {
        Job newJob = jobService.updateJob(id, tittle, location);
        if(!Objects.equals(newJob, null)) {
            return new ResponseEntity<>(newJob, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
