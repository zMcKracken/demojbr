package com.acme.demojbr.config;

import org.jobrunr.jobs.Job;
import org.jobrunr.jobs.filters.ApplyStateFilter;
import org.jobrunr.jobs.filters.ElectStateFilter;
import org.jobrunr.jobs.states.JobState;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.StorageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

public class CustomJobFilter implements ApplyStateFilter, ElectStateFilter {

    final JobScheduler jobScheduler;
    final StorageProvider storageProvider;
    final Environment env;

    private static final Logger logger = LoggerFactory.getLogger(CustomJobFilter.class);

    public CustomJobFilter(JobScheduler jobScheduler, StorageProvider storageProvider, Environment env) {
        this.jobScheduler = jobScheduler;
        this.storageProvider = storageProvider;
        this.env = env;
    }

    @Override
    public void onStateApplied(Job job, JobState oldState, JobState newState) {
        logger.info("onStateApplied");
        logger.info(job.getId().toString());
        logger.info("OLD: " + oldState.getName().toString());
        logger.info("NEW: " + newState.getName().toString());
    }

    @Override
    public void onStateElection(Job job, JobState jobState) {
        logger.info("onStateElection");
        logger.info(job.getId().toString());
        logger.info(job.getJobState().getName().toString());
        logger.info(jobState.getName().toString());


    }

}
