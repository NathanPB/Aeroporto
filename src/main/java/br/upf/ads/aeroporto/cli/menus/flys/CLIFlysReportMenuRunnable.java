package br.upf.ads.aeroporto.cli.menus.flys;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class CLIFlysReportMenuRunnable extends CLIMenuRunnable {

    public CLIFlysReportMenuRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        cli.getOut().println("Relatório de Vôos");
        // TODO Imprimir relatório dos vôos
    }

    @Override
    public String getDescription() {
        return "Relatório de Vôos";
    }

    @Override
    public char getKey() {
        return 'R';
    }
}
