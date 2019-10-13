package br.upf.ads.aeroporto.cli.menus.flys;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class CLIFlysReportMenuRunnable extends CLIMenuRunnable {

    public CLIFlysReportMenuRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        super.run();
        // TODO Imprimir relatório dos vôos
    }

    @Override
    public String getInitialDialog() {
        return "Relatório de vôos:";
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
