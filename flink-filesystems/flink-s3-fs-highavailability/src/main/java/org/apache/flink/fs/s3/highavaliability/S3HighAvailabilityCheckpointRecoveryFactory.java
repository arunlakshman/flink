package org.apache.flink.fs.s3.highavaliability;

import org.apache.flink.api.common.JobID;
import org.apache.flink.runtime.checkpoint.CheckpointIDCounter;
import org.apache.flink.runtime.checkpoint.CheckpointRecoveryFactory;
import org.apache.flink.runtime.checkpoint.CompletedCheckpointStore;
import org.apache.flink.runtime.jobgraph.RestoreMode;
import org.apache.flink.runtime.state.SharedStateRegistryFactory;

import java.util.concurrent.Executor;

public class S3HighAvailabilityCheckpointRecoveryFactory implements CheckpointRecoveryFactory {

    @Override
    public CompletedCheckpointStore createRecoveredCompletedCheckpointStore(
            JobID jobId,
            int maxNumberOfCheckpointsToRetain,
            SharedStateRegistryFactory sharedStateRegistryFactory,
            Executor ioExecutor,
            RestoreMode restoreMode) throws Exception {
        return null;
    }

    @Override
    public CheckpointIDCounter createCheckpointIDCounter(JobID jobId) throws Exception {
        return null;
    }
}
