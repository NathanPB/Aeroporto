package br.upf.ads.aeroporto.cli.menus;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class CLIExitMenuRunnable extends CLIMenuRunnable {
    public CLIExitMenuRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        cli.getOut().println("Saindo...");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Sair";
    }

    @Override
    public char getKey() {
        return 'S';
    }
}
