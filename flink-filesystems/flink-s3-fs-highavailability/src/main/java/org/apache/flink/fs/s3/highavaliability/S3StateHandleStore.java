package org.apache.flink.fs.s3.highavaliability;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.runtime.persistence.IntegerResourceVersion;
import org.apache.flink.runtime.persistence.PossibleInconsistentStateException;
import org.apache.flink.runtime.persistence.StateHandleStore;
import org.apache.flink.runtime.state.RetrievableStateHandle;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class S3StateHandleStore<T extends Serializable>
        implements StateHandleStore<T, IntegerResourceVersion> {

    @Override
    public RetrievableStateHandle<T> addAndLock(
            String name,
            T state) throws PossibleInconsistentStateException, Exception {
        return null;
    }

    @Override
    public void replace(
            String name,
            IntegerResourceVersion resourceVersion,
            T state) throws PossibleInconsistentStateException, Exception {

    }

    @Override
    public IntegerResourceVersion exists(String name) throws Exception {
        return null;
    }

    @Override
    public RetrievableStateHandle<T> getAndLock(String name) throws Exception {
        return null;
    }

    @Override
    public List<Tuple2<RetrievableStateHandle<T>, String>> getAllAndLock() throws Exception {
        return List.of();
    }

    @Override
    public Collection<String> getAllHandles() throws Exception {
        return List.of();
    }

    @Override
    public boolean releaseAndTryRemove(String name) throws Exception {
        return false;
    }

    @Override
    public void clearEntries() throws Exception {

    }

    @Override
    public void release(String name) throws Exception {

    }

    @Override
    public void releaseAll() throws Exception {

    }
}
