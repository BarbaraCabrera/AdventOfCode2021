package com.liferay.adventofcode2021;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
	public static void main(String[] args) throws IOException {

		ClassLoader classLoader = Day1.class.getClassLoader();
		File file = new File(classLoader.getResource("day1").getFile());

		System.out.println(firstPart(Files.lines(file.toPath())));
		System.out.println(
			firstPartWithFor(Files.lines(file.toPath())));


		System.out.println(
			secondPartWithForIncreasing(Files.lines(file.toPath())));
		System.out.println(
			secondPartWithForDecreasing(Files.lines(file.toPath())));
	}

	private static String firstPartWithFor(Stream<String> lines) {
		List<Integer> beeps =
			lines.map(Integer::parseInt).collect(Collectors.toList());

		AtomicInteger counter = new AtomicInteger();

		//you must store all the list on memory
		for (int i = 1; i < beeps.size(); i++) {
			if (beeps.get(i) > beeps.get(i - 1)) {
				counter.getAndIncrement();
			}
		}
		return String.valueOf(counter);
	}

	private static AtomicInteger firstPart(Stream<String> lines) {

		AtomicInteger counter = new AtomicInteger();

		lines.map(Integer::parseInt).reduce((x, y) -> {
			if (x < y) {
				counter.getAndIncrement();
			}
			return y;
		});
		return counter;
	}

	private static String secondPartWithForIncreasing(Stream<String> lines) {
		List<Integer> beeps =
			lines.map(Integer::parseInt).collect(Collectors.toList());

		AtomicInteger counter = new AtomicInteger();

		for (int i = 0; i < beeps.size() - 3; i++) {
			int x = beeps.get(i) + beeps.get(i + 1) + beeps.get(i + 2);
			int y = beeps.get(i + 1) + beeps.get(i + 2) + beeps.get(i + 3);
			if (x < y) {
				counter.getAndIncrement();
			}
		}
		return String.valueOf(counter);
	}

	private static String secondPartWithForDecreasing(Stream<String> lines) {
		List<Integer> beeps =
			lines.map(Integer::parseInt).collect(Collectors.toList());

		AtomicInteger counter = new AtomicInteger();

		for (int i = 3; i < beeps.size(); i++) {
			int x = beeps.get(i - 3) + beeps.get(i - 2) + beeps.get(i - 1);
			int y = beeps.get(i - 2) + beeps.get(i - 1) + beeps.get(i);
			if (x < y) {
				counter.getAndIncrement();
			}
		}
		return String.valueOf(counter);
	}

}
