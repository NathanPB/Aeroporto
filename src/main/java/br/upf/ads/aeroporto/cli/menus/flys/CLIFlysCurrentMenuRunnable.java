package br.upf.ads.aeroporto.cli.menus.flys;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class CLIFlysCurrentMenuRunnable extends CLIMenuRunnable {

    public CLIFlysCurrentMenuRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        super.run();
        // TODO Imprimir vôos em andamento
    }

    @Override
    public String getDescription() {
        return "Vôos em Andamento";
    }

    @Override
    public String getInitialDialog() {
        return getDescription() + ":";
    }

    @Override
    public char getKey() {
        return 'A';
    }
}
