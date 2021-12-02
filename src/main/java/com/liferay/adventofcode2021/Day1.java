package com.liferay.adventofcode2021;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
	public static void main(String[] args) throws IOException {

		ClassLoader classLoader = Day1.class.getClassLoader();
		File file = new File(classLoader.getResource("day1").getFile());

		System.out.println( firstPart(Files.lines(Path.of(file.getPath()))));

		System.out.println(firstPartWithFor(Files.lines(Path.of(file.getPath()))));


	}

	private static AtomicInteger firstPart(Stream<String> lines) {

		AtomicInteger counter = new AtomicInteger();

		lines.map(Integer::parseInt).reduce((x, y) -> {
			if (x < y){
				counter.getAndIncrement();
			}
			return y;
		});
		return counter;
	}



	private static String firstPartWithFor(Stream<String> lines) {
		List<Integer> beeps = lines.map(Integer::parseInt).collect(Collectors.toList());

		AtomicInteger counter = new AtomicInteger();
int counter2 = 0;
		//you must store all the list on memory
		for(int i = 1; i < beeps.size(); i++){
			if(beeps.get(i) > beeps.get(i-1)){
				counter.getAndIncrement();
				counter2++;
			}
		}
		return String.valueOf(counter);
	}
	
	
	private static String firstPartWithFor(Stream<String> lines) {
		List<Integer> beeps = lines.map(Integer::parseInt).collect(Collectors.toList());
		AtomicInteger counter = new AtomicInteger();

		//you must store all the list on memory
		for(int i = 0; i < beeps.size()-3; i++){
			Integer val1 = beeps.get(i)+beeps.get(i+1)+beeps.get(i+2);
			Integer val2 = beeps.get(i+1)+beeps.get(i+2)+beeps.get(i+3);
			
			if(val2>val1){
				counter.getAndIncrement();
			}
		}
		return String.valueOf(counter);
	}
	

}
