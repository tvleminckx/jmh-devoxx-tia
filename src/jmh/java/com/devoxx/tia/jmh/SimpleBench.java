package com.devoxx.tia.jmh;

import java.util.regex.Pattern;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Benchmark)
public class SimpleBench {

	
	@Setup
	public void setupMyBenchMark() {

	}

	private String input = "crowd==devoxx";
	private Pattern pattern = Pattern.compile("==");
	
	@Benchmark
	public String[] benchOne() {
		
		return input.split("==",2);
	}

	@Benchmark
	public String[] benchTwo() {
		
		return pattern.split(input,2);
	}

	@TearDown
	public void tearDownMyBenchMark() {
	}
	
}
