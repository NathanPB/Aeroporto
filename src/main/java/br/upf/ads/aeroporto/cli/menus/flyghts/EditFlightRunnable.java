package br.upf.ads.aeroporto.cli.menus.flyghts;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuCollection;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.cli.menus.flyghts.flightRange.AddFlightRangeRunnable;
import br.upf.ads.aeroporto.utils.DOMUtils;
import br.upf.ads.aeroporto.utils.ReaderUtils;
import org.w3c.dom.Element;

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
        menus.add(new AddFlightRangeRunnable(cli, ranges));

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
