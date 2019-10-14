package br.upf.ads.aeroporto.cli.menus.flys;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.cli.CLIMenuCollection;
import br.upf.ads.aeroporto.cli.menus.CLIBackMenuRunnable;

public class CLIFlysMenuRunnable extends CLIMenuRunnable {
    private static CLIMenuCollection menuList = new CLIMenuCollection(new CLIMenuRunnable[]{

    });

    public CLIFlysMenuRunnable(CLI cli, CLIMenuRunnable lastMenu) {
        super(cli);
        menuList.add(new CLIFlysReportMenuRunnable(cli));
        menuList.add(new CLIFlysCurrentMenuRunnable(cli));
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
