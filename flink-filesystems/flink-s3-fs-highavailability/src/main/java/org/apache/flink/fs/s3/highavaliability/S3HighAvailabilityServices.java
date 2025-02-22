package org.apache.flink.fs.s3.highavaliability;

import org.apache.flink.api.common.JobID;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.blob.BlobStoreService;
import org.apache.flink.runtime.checkpoint.CheckpointRecoveryFactory;
import org.apache.flink.runtime.highavailability.AbstractHaServices;
import org.apache.flink.runtime.highavailability.JobResultStore;
import org.apache.flink.runtime.jobmanager.JobGraphStore;
import org.apache.flink.runtime.leaderelection.LeaderElectionDriverFactory;
import org.apache.flink.runtime.leaderretrieval.LeaderRetrievalService;

import java.util.concurrent.Executor;

public final class S3HighAvailabilityServices extends AbstractHaServices {

    protected S3HighAvailabilityServices(
            Configuration config,
            Executor ioExecutor,
            BlobStoreService blobStoreService,
            JobResultStore jobResultStore) {
        super(config, ioExecutor, blobStoreService, jobResultStore);
    }

    @Override
    protected LeaderElectionDriverFactory createLeaderElectionDriverFactory(String leaderName) {
        return null;
    }

    @Override
    protected LeaderRetrievalService createLeaderRetrievalService(String leaderName) {
        return null;
    }

    @Override
    protected CheckpointRecoveryFactory createCheckpointRecoveryFactory() throws Exception {
        return null;
    }

    @Override
    protected JobGraphStore createJobGraphStore() throws Exception {
        return null;
    }

    @Override
    protected void internalClose() throws Exception {

    }

    @Override
    protected void internalCleanup() throws Exception {

    }

    @Override
    protected void internalCleanupJobData(JobID jobID) throws Exception {

    }

    @Override
    protected String getLeaderPathForResourceManager() {
        return "";
    }

    @Override
    protected String getLeaderPathForDispatcher() {
        return "";
    }

    @Override
    protected String getLeaderPathForJobManager(JobID jobID) {
        return "";
    }

    @Override
    protected String getLeaderPathForRestServer() {
        return "";
    }
}
