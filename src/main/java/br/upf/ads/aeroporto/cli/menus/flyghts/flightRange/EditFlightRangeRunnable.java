package br.upf.ads.aeroporto.cli.menus.flyghts.flightRange;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuCollection;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.utils.MutableContainer;
import br.upf.ads.aeroporto.utils.ReaderUtils;
import org.w3c.dom.Element;

import java.util.stream.Stream;

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
        if(this.range == null) {
            this.range = ReaderUtils.chooseRange(cli, this.ranges.getChildNodes());
        }

        MutableContainer<Boolean> stillInMenu = new MutableContainer<>(true);


        Stream.of(
            new EditAirportRunnable(cli, range),
            new CLIMenuRunnable(cli) {
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
        }
        )
            .filter(it -> menus.stream().map(Object::getClass).noneMatch(c2 -> c2.equals(it.getClass())))
            .forEach(menus::add);
        while (stillInMenu.get()) menus.showChooseDialog(cli);
    }

    @Override
    public String getDescription() {
        return "Editar Escala";
    }

    @Override
    public char getKey() {
        return 'E';
    }
}
