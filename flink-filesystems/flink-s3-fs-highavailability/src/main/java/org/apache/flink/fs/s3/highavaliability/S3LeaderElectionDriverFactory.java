package org.apache.flink.fs.s3.highavaliability;

import org.apache.flink.runtime.leaderelection.LeaderElectionDriver;
import org.apache.flink.runtime.leaderelection.LeaderElectionDriverFactory;
import org.apache.flink.runtime.leaderelection.LeaderElectionEventHandler;
import org.apache.flink.runtime.rpc.FatalErrorHandler;

public class S3LeaderElectionDriverFactory implements LeaderElectionDriverFactory {
    @Override
    public LeaderElectionDriver createLeaderElectionDriver(
            LeaderElectionEventHandler leaderEventHandler,
            FatalErrorHandler fatalErrorHandler) throws Exception {
        return null;
    }
}
