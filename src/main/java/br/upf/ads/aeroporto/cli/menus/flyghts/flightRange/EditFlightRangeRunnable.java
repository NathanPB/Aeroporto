package br.upf.ads.aeroporto.cli.menus.flyghts.flightRange;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuCollection;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.cli.menus.CLIBackMenuRunnable;
import br.upf.ads.aeroporto.utils.MutableContainer;
import org.w3c.dom.Element;

import java.util.Optional;

public class EditFlightRangeRunnable extends CLIMenuRunnable {
    private CLIMenuCollection menus = new CLIMenuCollection();

    private Element range;
    private Element ranges;

    public EditFlightRangeRunnable(CLI cli, Element range, Element ranges) {
        super(cli);
        this.range = range;
        this.ranges = ranges;
    }

    @Override
    public void run() {
        MutableContainer<Boolean> stillInMenu = new MutableContainer<>(true);

        menus.add(new EditAirportRunnable(cli, range));
        menus.add(new CLIMenuRunnable(cli) {
            @Override
            public String getDescription() {
                return "Voltar";
            }

            @Override
            public char getKey() {
                return 'V';
            }

            @Override
            public void run() {
                stillInMenu.set(false);
            }
        });
        while (stillInMenu.get()) menus.showChooseDialog(cli);
    }

    @Override
    public String getDescription() {
        return "Editar ou Reordenar Escala";
    }

    @Override
    public char getKey() {
        return 'E';
    }
}
