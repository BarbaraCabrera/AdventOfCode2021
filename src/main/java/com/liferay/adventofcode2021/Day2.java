package com.liferay.adventofcode2021;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {

    private static final String FORWARD = "forward";

    private static final String UP = "up";

    private static final String DOWN = "down";

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Day2.class.getClassLoader();
        //File file = new File(classLoader.getResource("Day2.rtf").getFile());

        // in my case the name of the file is diff.
        File file = new File(classLoader.getResource("day2.txt").getFile());


        System.out.println(firstPartWithFor(Files.lines(file.toPath())));
        //(sum(down) - sum(up))*sum(forward)

        // I will reuse the list so I extract here to pass to the methods
        List<String> list = Files.lines(file.toPath()).collect(
                Collectors.toList());

        System.out.println(firstPartWithForWithSubstring(list));
        System.out.println(firstPartWithLambdas(list));
        System.out.println(secondPartWithForWithSubstring(list));

    }

    private static String firstPartWithFor(Stream<String> lines) {
        List<String> beeps = lines.collect(Collectors.toList());
        Integer counterF = 0;
        Integer counterD = 0;
        Integer counterU = 0;

        for (int i = 0; i < beeps.size(); i++) {

            String desplazamiento = beeps.get(i);
            System.out.print("\n" + desplazamiento + "\n");
            String[] movimientos = desplazamiento.split(" ");
            System.out.print("\n" + movimientos[0] + "\n");

            if (movimientos[0].equals("forward")) {
                counterF += Integer.parseInt(movimientos[1]);
            } else if (movimientos[0].equals("down")) {
                counterD += Integer.parseInt(movimientos[1]);
            } else {
                counterU += Integer.parseInt(movimientos[1]);
            }
        }
        Integer Result = counterF * (counterD - counterU);

        return String.valueOf(Result);
    }

    private static int firstPartWithForWithSubstring(List<String> lines) {

        int forward = 0;
        int down = 0;

        for (String line : lines) {
            if (line.startsWith(FORWARD)) {
                forward +=
                        Integer.parseInt(line.substring(FORWARD.length()).trim());
            } else if (line.startsWith(DOWN)) {
                down += Integer.parseInt(line.substring(DOWN.length()).trim());
            } else if (line.startsWith(UP)) {
                down -= Integer.parseInt(line.substring(UP.length()).trim());
            }
        }

        return forward * down;

    }

    private static int secondPartWithForWithSubstring(List<String> lines) {

        int aim = 0;
        int horizontal = 0;
        int depth = 0;

        for (String line : lines) {
            if (line.startsWith(FORWARD)) {
                depth +=
                        Integer.parseInt(line.substring(FORWARD.length()).trim()) *
                                aim;
                horizontal +=
                        Integer.parseInt(line.substring(FORWARD.length()).trim());
            } else if (line.startsWith(DOWN)) {
                aim += Integer.parseInt(line.substring(DOWN.length()).trim());
            } else if (line.startsWith(UP)) {
                aim -= Integer.parseInt(line.substring(UP.length()).trim());
            }
        }

        return horizontal * depth;

    }

    private static int firstPartWithLambdas(List<String> lines) {

        Integer forward = getSumOfDirection(lines.stream(), FORWARD);
        Integer up = getSumOfDirection(lines.stream(), UP);
        Integer down = getSumOfDirection(lines.stream(), DOWN);

        return forward * (down - up);

    }

    private static Integer getSumOfDirection(
            Stream<String> lines, String direction) {
        return lines.filter(line -> line.startsWith(direction)).map(
                line -> line.substring(direction.length()).trim()).map(
                Integer::parseInt).reduce(0, Integer::sum);
    }

}
