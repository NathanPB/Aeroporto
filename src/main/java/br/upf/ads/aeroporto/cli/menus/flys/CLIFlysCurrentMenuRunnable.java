package br.upf.ads.aeroporto.cli.menus.flys;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class CLIFlysCurrentMenuRunnable extends CLIMenuRunnable {

    public CLIFlysCurrentMenuRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        cli.getOut().println("Vôos em Andamento:");
        // TODO Imprimir vôos em andamento
    }

    @Override
    public String getDescription() {
        return "Vôos em Andamento";
    }

    @Override
    public char getKey() {
        return 'A';
    }
}
