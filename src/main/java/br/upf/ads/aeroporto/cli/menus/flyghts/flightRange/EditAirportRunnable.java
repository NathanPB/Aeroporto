package br.upf.ads.aeroporto.cli.menus.flyghts.flightRange;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.utils.ReaderUtils;
import org.w3c.dom.Element;

public class EditAirportRunnable extends CLIMenuRunnable {
    private Element range;

    public EditAirportRunnable(CLI cli, Element range) {
        super(cli);
        this.range = range;
    }

    @Override
    public void run() {
        range.setAttribute("aeroporto", ReaderUtils.chooseAirport(cli, "Escolha o Aeroporto:"));
        cli.getOut().println("Aeroporto Editado!");
    }

    @Override
    public String getDescription() {
        return "Editar Aeroporto";
    }

    @Override
    public char getKey() {
        return 'A';
    }
}
