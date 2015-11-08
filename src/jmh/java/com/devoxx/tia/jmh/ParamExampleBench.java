package com.devoxx.tia.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ParamExampleBench {

	@Param({ "one", "two", "three" })
	private String input;

	@Benchmark
	public int bench() {
		return input.length();
	}
}


