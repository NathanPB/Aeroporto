package br.upf.ads.aeroporto.cli.menus.flyghts;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.cli.CLIMenuCollection;
import br.upf.ads.aeroporto.cli.menus.CLIBackMenuRunnable;

public class CLIFlyghtsMenuRunnable extends CLIMenuRunnable {
    private static CLIMenuCollection menuList = new CLIMenuCollection(new CLIMenuRunnable[]{

    });

    public CLIFlyghtsMenuRunnable(CLI cli, CLIMenuRunnable lastMenu) {
        super(cli);
        menuList.add(new CLIFlyghtsReportMenuRunnable(cli));
        menuList.add(new CLIFlyghtsCurrentMenuRunnable(cli));
        menuList.add(new CLIBackMenuRunnable(cli, lastMenu));
    }

    @Override
    public void run() {
        cli.getOut().println("Escolha uma opção:");
        menuList.showChooseDialog(cli);
    }

    @Override
    public String getDescription() {
        return "Manutenção de Vôos";
    }

    @Override
    public char getKey() {
        return 'V';
    }
}
