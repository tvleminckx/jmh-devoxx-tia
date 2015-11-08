package com.devoxx.tia.jmh;

import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class ProfilerDemoBench {

	private Map<Long, Boolean> map = new HashMap<Long, Boolean>();

	// private ConcurrentHashMap<Long, Boolean> map = new
	// ConcurrentHashMap<Long, Boolean>();

	@Param(value = { "0", "1000" })
	private long tokens;

	public void doSomething(long id) {

		synchronized (map) {
			if (!map.containsKey(id))
				map.put(id, Boolean.TRUE);
		}
		// map.putIfAbsent(id, Boolean.TRUE);
	}

	@Benchmark
	public void record() {

		Blackhole.consumeCPU(tokens);

		long id = Thread.currentThread().getId();
		
		doSomething(id);
	}

}
