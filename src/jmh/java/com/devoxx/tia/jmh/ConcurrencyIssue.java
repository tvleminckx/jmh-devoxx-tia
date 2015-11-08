package com.devoxx.tia.jmh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.GroupThreads;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ConcurrencyIssue {

	private Random random = new Random();
	
	private List<String> config = Collections.synchronizedList(new ArrayList<String>() {
		{
			add("x");
		}
	});

	@GroupThreads(7)
	@Group("race")
	@Benchmark
	public String benchRead() {
		return config.get(0);	
	}

	@GroupThreads(1)
	@Group("race")
	@Benchmark()
	public String benchWrite() {
		
		config.remove(0);
		config.add(0, Integer.toString(random.nextInt()));
		
		return config.get(0);

	}
}
