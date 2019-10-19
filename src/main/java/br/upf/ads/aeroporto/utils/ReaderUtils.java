package br.upf.ads.aeroporto.utils;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderUtils {
    public static String chooseAirport(CLI cli, String message) {
        while (true) {
            if(message != null) cli.getOut().println(message);
            Main.aeroportos
                .entrySet()
                .stream()
                .map(e -> e.getKey() + ") " + e.getValue())
                .forEach(cli.getOut()::println);
            String airport = cli.getScanner().nextLine();
            if(Main.aeroportos.containsKey(airport)) {
                return airport;
            } else {
                cli.getOut().println("Aeroporto Inválido!");
            }
        }
    }

    public static String chooseFlight(CLI cli, String message) {
        List<String> flights = DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
            .map(it -> it.getAttribute("id"))
            .collect(Collectors.toList());

        while (true) {
            if(message != null) cli.getOut().println(message);
            cli.getOut().println(String.join(", ", flights));
            String flight = cli.getScanner().nextLine();
            if(flights.contains(flight)) {
                return flight;
            } else {
                cli.getOut().println("Vôo Inválido!");
            }
        }
    }
}
