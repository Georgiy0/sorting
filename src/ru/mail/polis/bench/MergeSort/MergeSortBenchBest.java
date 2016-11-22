package ru.mail.polis.bench.MergeSort;

/**
 * Created by kubri on 11/21/2016.
 */

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.MergeSort;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MergeSortBenchBest {

    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation2() {
        int n = 1000;
        a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = i;
    }

    @Benchmark
    public void measureInsertionSort(Blackhole bh) {
        bh.consume(MergeSort.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeSortBenchBest.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
