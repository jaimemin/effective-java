package com.tistory.jaimemin.effectivejava.ch09.item66;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessApiExample {

	public static void main(String[] args) {
		// Get the runtime bean
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

		// Get the process ID of the current Java process
		long pid = ProcessHandle.current().pid();
		System.out.println("현재 프로세스 ID: " + pid);

		// Get information about all running processes
		List<ProcessHandle> processes = ProcessHandle.allProcesses().collect(Collectors.toList());

		// Print information about each process
		System.out.println("실행중인 프로세스 목록:");

		for (ProcessHandle process : processes) {
			System.out.println(
				"PID: " + process.pid() + ", Command: " + getCommand(process) + ", Alive: " + process.isAlive());
		}
	}

	// Helper method to get the command associated with a process
	private static String getCommand(ProcessHandle process) {
		return process.info().command().orElse("Unknown");
	}
}

