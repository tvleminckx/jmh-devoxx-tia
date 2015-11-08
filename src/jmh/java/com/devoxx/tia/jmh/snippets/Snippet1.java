package com.devoxx.tia.jmh.snippets;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Benchmark)
public class Snippet1 {
	
	
	@Setup
	public void setupMyBenchMark() {

	}
	
	@Benchmark
	public String[] bench() {
		return "crowd==devoxx".split("==");
	}
	
	@TearDown
	public void tearDownMyBenchMark() {
	}

	
}
