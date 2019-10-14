package br.upf.ads.aeroporto.cli.menus;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;

public class CLIBackMenuRunnable extends CLIMenuRunnable {
    private CLIMenuRunnable lastMenu;

    public CLIBackMenuRunnable(CLI cli, CLIMenuRunnable lastMenu) {
        super(cli);
        this.lastMenu = lastMenu;
    }

    @Override
    public void run() {
        lastMenu.run();
    }

    @Override
    public String getDescription() {
        return "Voltar";
    }

    @Override
    public char getKey() {
        return 'Z';
    }
}
