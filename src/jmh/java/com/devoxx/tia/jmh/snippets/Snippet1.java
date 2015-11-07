package com.devoxx.tia.jmh.snippets;

import org.openjdk.jmh.annotations.Benchmark;

public class Snippet1 {
	
	@Benchmark
	public String[] bench() {
		return "crowd==devoxx".split("==");
	}
	
}
