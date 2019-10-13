package br.upf.ads.aeroporto.cli.menus;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.cli.CLIMenuCollection;
import br.upf.ads.aeroporto.cli.menus.flys.CLIFlysMenuRunnable;
import br.upf.ads.aeroporto.utils.DateTimeUtils;

public class CLIInitialMenuRunnable extends CLIMenuRunnable {

    private static CLIMenuCollection menuList = new CLIMenuCollection();

    public CLIInitialMenuRunnable(CLI cli) {
        super(cli);
         menuList.add(new CLIFlysMenuRunnable(cli, this));
         menuList.add(new CLIExitMenuRunnable(cli));
    }

    @Override
    public void run() {
        super.run();
        menuList.showChooseDialog(this.cli);
    }

    @Override
    public String getInitialDialog() {
        return "Bem Vindo! [" + DateTimeUtils.formatCurrentDateTime() + "]";
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
