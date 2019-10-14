package br.upf.ads.aeroporto.cli.menus.flyghts;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class CLIFlyghtsCurrentMenuRunnable extends CLIMenuRunnable {

    public CLIFlyghtsCurrentMenuRunnable(CLI cli) {
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
