package org.apache.flink.fs.s3.highavaliability;

import org.apache.flink.runtime.leaderelection.LeaderElectionDriver;
import org.apache.flink.runtime.leaderelection.LeaderInformation;

public class S3LeaderElectionDriver implements LeaderElectionDriver {
    @Override
    public void writeLeaderInformation(LeaderInformation leaderInformation) {

    }

    @Override
    public boolean hasLeadership() {
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}
