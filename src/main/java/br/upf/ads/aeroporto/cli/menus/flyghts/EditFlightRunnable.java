package br.upf.ads.aeroporto.cli.menus.flyghts;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuCollection;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.cli.menus.flyghts.flightRange.AddFlightRangeRunnable;
import br.upf.ads.aeroporto.cli.menus.flyghts.flightRange.EditFlightRangeRunnable;
import br.upf.ads.aeroporto.utils.DOMUtils;
import br.upf.ads.aeroporto.utils.ReaderUtils;
import org.w3c.dom.Element;

import java.util.stream.Stream;

public class EditFlightRunnable extends CLIMenuRunnable {
    private Element flight;
    private CLIMenuCollection menus = new CLIMenuCollection();

    public EditFlightRunnable(CLI cli, Element flight) {
        super(cli);
        this.flight = flight;
    }

    @Override
    public void run() {
        Element flight = this.flight;
        if(flight == null) {
            String choosedFLight = ReaderUtils.chooseFlight(cli, "Escolha um Vôo:");
            flight = DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
                .filter(it -> it.getAttribute("id").equalsIgnoreCase(choosedFLight))
                .findFirst().get();
        }
        Element ranges = (Element) flight.getElementsByTagName("escala").item(0);

        Stream.of(
            new AddFlightRangeRunnable(cli, ranges),
            new EditFlightRangeRunnable(cli, null, ranges)
        )
            .filter(it -> menus.stream().map(Object::getClass).noneMatch(c2 -> c2.equals(it.getClass())))
            .forEach(menus::add);

        menus.showChooseDialog(cli);
    }

    @Override
    public String getDescription() {
        return "Editar Vôo";
    }

    @Override
    public char getKey() {
        return 'E';
    }
}
