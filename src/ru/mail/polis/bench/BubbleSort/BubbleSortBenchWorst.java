package ru.mail.polis.bench.BubbleSort;

/**
 * Created by kubri on 11/21/2016.
 */

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.BubbleSort;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BubbleSortBenchWorst {

    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation2() {
        int n = 1000;
        a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = n-i;
    }

    @Benchmark
    public void measureInsertionSort(Blackhole bh) {
        bh.consume(BubbleSort.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BubbleSortBenchWorst.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
