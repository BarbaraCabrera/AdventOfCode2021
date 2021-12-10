package com.liferay.adventofcode2021;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Day3.class.getClassLoader();
        File file = new File(classLoader.getResource("Day3.rtf").getFile());

        System.out.println(firstPart(Files.lines(file.toPath())));
        // System.out.println(secondPart(Files.lines(file.toPath())));
    }

    private static String firstPart(Stream<String> lines) {
        List<String> beeps = lines.collect(Collectors.toList());
        int[] counterOfOnes = new int[beeps.get(1).length()];
        StringBuilder gammaRateSB = new StringBuilder();
        StringBuilder epsilonRateSB = new StringBuilder();


        for (int i = 0; i < beeps.size(); i++) {
            extracted(beeps, counterOfOnes, i);
        }
        for (int k = 0; k < beeps.get(1).length(); k++) {

            if (counterOfOnes[k] > (beeps.size() / 2)) {
                gammaRateSB.append("1");
                epsilonRateSB.append("0");
            } else {
                gammaRateSB.append("0");
                epsilonRateSB.append("1");
            }
        }

        String gamma = gammaRateSB.toString();
        String epsilon = epsilonRateSB.toString();
        Integer powerCons = Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);


        return String.valueOf(powerCons);
    }

    private static void extracted(List<String> beeps, int[] counterOfOnes, int i) {
        for (int j = 0; j < beeps.get(i).length(); j++) {
            if (beeps.get(i).charAt(j) == '1') {
                counterOfOnes[j]++;
            }
        }

    }


    //Part 2

    private static String secondPart(Stream<String> lines) {
        List<String> oxigen = lines.collect(Collectors.toList());
        List<String> CO2 = new ArrayList<>(oxigen);
        int[] counterOfOnes = new int[oxigen.get(1).length()];
        StringBuilder gammaRateSB = new StringBuilder();
        StringBuilder epsilonRateSB = new StringBuilder();


        for (int j = 0; j < oxigen.get(1).length(); j++) {
            for (int i = 0; i < oxigen.size(); i++) {
                if (oxigen.get(i).charAt(j) == '1') {
                    counterOfOnes[j]++;
                }
            }

        }
        for (int k = 0; k < oxigen.get(1).length(); k++) {

            if (counterOfOnes[k] > (oxigen.size() / 2)) {
                gammaRateSB.append("1");
                epsilonRateSB.append("0");
            } else {
                gammaRateSB.append("0");
                epsilonRateSB.append("1");
            }
        }

        String gamma = gammaRateSB.toString();
        String epsilon = epsilonRateSB.toString();
        Integer powerCons = Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);


        return String.valueOf(powerCons);
    }
    
    private List<String> getListwithPrioritaryByte(List<String> original, int position){

        int[] counterOfOnes = new int[original.get(1).length()];
        List<String> Retorno = new ArrayList<String>();
        extracted(original, counterOfOnes, position);


        for (String line : original) {
            if(line.charAt(position).equal())
        }

    }
}
