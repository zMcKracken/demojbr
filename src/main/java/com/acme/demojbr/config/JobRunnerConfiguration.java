package com.acme.demojbr.config;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.configuration.JobRunrConfiguration;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.StorageProviderUtils;
import org.jobrunr.storage.sql.common.DefaultSqlStorageProvider;
import org.jobrunr.storage.sql.postgres.PostgresDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class JobRunnerConfiguration {

    @Autowired
    DataSource dataSource;
    @Autowired
    JobScheduler jobScheduler;
    @Autowired
    StorageProvider storageProvider;
    @Autowired
    Environment env;

   @Bean
    public JobRunrConfiguration.JobRunrConfigurationResult jobRunrConfiguration() {
        return JobRunr.configure()
                .useStorageProvider(new DefaultSqlStorageProvider(dataSource, new PostgresDialect(), StorageProviderUtils.DatabaseOptions.SKIP_CREATE))
                .withJobFilter(new CustomJobFilter(jobScheduler,  storageProvider,  env),new CustomJobFilter2())
                .useBackgroundJobServer(1)
                .useDashboard()
                .initialize();
    }
}
