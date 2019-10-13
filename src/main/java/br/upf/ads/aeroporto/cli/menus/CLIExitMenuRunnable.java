package br.upf.ads.aeroporto.cli.menus;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class CLIExitMenuRunnable extends CLIMenuRunnable {
    public CLIExitMenuRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        super.run();
        System.exit(0);
    }

    @Override
    public String getInitialDialog() {
        return "Saindo...";
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
