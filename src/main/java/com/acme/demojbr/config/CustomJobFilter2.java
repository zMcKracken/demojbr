package com.acme.demojbr.config;

import org.jobrunr.jobs.AbstractJob;
import org.jobrunr.jobs.Job;
import org.jobrunr.jobs.filters.JobClientFilter;
import org.jobrunr.jobs.filters.JobServerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomJobFilter2 implements JobClientFilter, JobServerFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomJobFilter2.class);

    public CustomJobFilter2() {
       logger.info("CustomJobFilter4 initialized");
    }

    public void onCreating(AbstractJob job) {
        logger.info( "onCreating");
    }


    public void onCreated(AbstractJob job) {
            logger.info( "onCreated");
    }

    public void onProcessingSucceeded(Job job) {
            logger.info("onProcessingSucceeded.");
    }

    public void onProcessingFailed(Job job, Exception e) {

        logger.info("failed.");
    }
}