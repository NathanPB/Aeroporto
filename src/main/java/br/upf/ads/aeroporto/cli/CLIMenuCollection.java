package br.upf.ads.aeroporto.cli;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class CLIMenuCollection extends ArrayList<CLIMenuRunnable> {

    public CLIMenuCollection() {

    }

    public CLIMenuCollection(CLIMenuRunnable[] array) {
        this.addAll(Arrays.asList(array));
    }

    public void showChooseDialog(CLI cli) {
        while (true) {
            PrintStream out = cli.getOut();
            this.stream()
                .map(it -> it.getKey() + ") " + it.getDescription())
                .forEach(out::println);

            out.println("> ");

            String choosed = cli.getScanner().next().toUpperCase().charAt(0) + "";
            Optional<CLIMenuRunnable> menu = this.stream()
                .filter(it -> (it.getKey() + "").equalsIgnoreCase(choosed))
                .findFirst();

            if(menu.isPresent()) {
                menu.get().run();
                break;
            } else {
                out.println("A opção '" + choosed + "' é inválida! Tente novamente");
            }
        }
    }
}
