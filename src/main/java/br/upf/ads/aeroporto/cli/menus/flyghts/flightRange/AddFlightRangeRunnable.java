package br.upf.ads.aeroporto.cli.menus.flyghts.flightRange;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import org.w3c.dom.Element;

public class AddFlightRangeRunnable extends CLIMenuRunnable {
    private Element ranges;

    public AddFlightRangeRunnable(CLI cli, Element ranges) {
        super(cli);
        this.ranges = ranges;
    }

    @Override
    public void run() {
        Element e = Main.voos.createElement("local");
        this.ranges.appendChild(e);
        new EditFlightRangeRunnable(cli, e, this.ranges).run();
    }

    @Override
    public String getDescription() {
        return "Adicionar Escala";
    }

    @Override
    public char getKey() {
        return 'A';
    }
}
