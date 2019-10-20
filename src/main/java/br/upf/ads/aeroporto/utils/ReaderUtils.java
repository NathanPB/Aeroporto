package br.upf.ads.aeroporto.utils;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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

    public static Element chooseElementFlight(CLI cli, String message) {
        List<String> flights = DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
            .map(it -> it.getAttribute("id"))
            .collect(Collectors.toList());

        while (true) {
            if(message != null) cli.getOut().println(message);
            cli.getOut().println(String.join(", ", flights));
            String flight = cli.getScanner().nextLine();

            Optional<Element> opt = DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
                .filter(it -> it.getAttribute("id").equals(flight))
                .findFirst();
            if(opt.isPresent()) {
                return opt.get();
            } else {
                cli.getOut().println("Vôo Inválido!");
            }
        }
    }

    public static String chooseFlight(CLI cli, String message) {
        return ReaderUtils.chooseElementFlight(cli, message).getAttribute("id");
    }

    public static int chooseInRange(CLI cli, int startInclusive, int endInclusive) {
        while (true) {
            cli.getOut().printf("Escolha uma posição: [%s .. %s]\n", startInclusive, endInclusive);
            try {
                int i = Integer.parseInt(cli.getScanner().nextLine());

                if(i >= startInclusive && i <= endInclusive) {
                    return i;
                } else throw new Exception();
            } catch (Exception ex) {
                cli.getOut().println("Posição Inválida!");
            }
        }
    }

    public static Element chooseRange(CLI cli, NodeList ranges) {
        MutableContainer<Integer> i = new MutableContainer<>(0);
        Function<String, String> indexer = (range) -> {
            String returnString = i.get() + ")\n" + range;
            i.set(i.get() + 1);
            return returnString;
        };

        List<Element> rangesElement = DOMUtils.toElementStream(ranges).collect(Collectors.toList());

        rangesElement
            .stream()
            .map(StringUtils::rangeToString)
            .map(indexer)
            .forEach(cli.getOut()::println);

        return (Element) rangesElement.get(ReaderUtils.chooseInRange(cli, 0, rangesElement.size()-1));
    }
}
