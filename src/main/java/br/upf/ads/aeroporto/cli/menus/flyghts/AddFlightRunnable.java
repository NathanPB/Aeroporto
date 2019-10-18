package br.upf.ads.aeroporto.cli.menus.flyghts;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.utils.DOMUtils;
import org.w3c.dom.Element;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AddFlightRunnable extends CLIMenuRunnable {

    public AddFlightRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        String id;
        Random random = new Random();
        List<String> existingFlights = DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
            .map(it -> it.getAttribute("id"))
            .collect(Collectors.toList());

        do {
            id = random.nextInt() + "";
        } while (existingFlights.contains(id));

        Element voo = Main.voos.createElement("voo");
        voo.setAttribute("id", id);
        Main.voos.getElementsByTagName("voos").item(0).appendChild(voo);
        cli.getOut().println("Adicionado Vôo " + id);

        //TODO persist
        //TODO open flight range edit menu
    }

    @Override
    public String getDescription() {
        return "Adicionar Vôo";
    }

    @Override
    public char getKey() {
        return 'A';
    }
}
