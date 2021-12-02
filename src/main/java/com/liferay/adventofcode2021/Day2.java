package com.liferay.adventofcode2021;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.String;

public class Day2 {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Day2.class.getClassLoader();
        File file = new File(classLoader.getResource("Day2.rtf").getFile());

        System.out.println(firstPartWithFor(Files.lines(file.toPath())));

    }

    private static String firstPartWithFor(Stream<String> lines) {
        List<String> beeps = lines.collect(Collectors.toList());
        Integer counterF = 0;
        Integer counterD = 0;
        Integer counterU = 0;

        for(int i = 0; i < beeps.size(); i++){

            String desplazamiento = beeps.get(i);
            System.out.print("\n" + desplazamiento + "\n");
            String[] movimientos = desplazamiento.split(" ");
            System.out.print("\n" + movimientos[0] + "\n");

            if(movimientos[0].equals("forward")) {
                counterF += Integer.parseInt(movimientos[1]);
            } else if (movimientos[0].equals("down")) {
                counterD += Integer.parseInt(movimientos[1]);
            } else {
                counterU += Integer.parseInt(movimientos[1]);
            }
        }
        Integer Result = counterF * (counterD-counterU);

        return String.valueOf(Result);
    }

}
