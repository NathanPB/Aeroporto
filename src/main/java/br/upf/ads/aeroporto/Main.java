package br.upf.ads.aeroporto;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.menus.CLIInitialMenuRunnable;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class Main {
    public static CLI cli = new CLI(System.in, System.out);
    public static CLIMenuRunnable initialMenu = new CLIInitialMenuRunnable(cli);

    public static void main(String[] args) {
        initialMenu.run();
    }
}
