package br.upf.ads.aeroporto.cli.menus;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.cli.CLIMenuCollection;
import br.upf.ads.aeroporto.cli.menus.flyghts.CLIFlyghtsCurrentMenuRunnable;
import br.upf.ads.aeroporto.utils.DateTimeUtils;

public class CLIInitialMenuRunnable extends CLIMenuRunnable {

    private static CLIMenuCollection menuList = new CLIMenuCollection();

    public CLIInitialMenuRunnable(CLI cli) {
        super(cli);
        menuList.add(new CLIFlyghtsCurrentMenuRunnable(cli));
        menuList.add(new CLIExitMenuRunnable(cli));
    }

    @Override
    public void run() {
        cli.getOut().println("Bem Vindo! [" + DateTimeUtils.formatCurrentDateTime() + "]");
        menuList.showChooseDialog(this.cli);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public char getKey() {
        return 0;
    }
}
