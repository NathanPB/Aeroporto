package br.upf.ads.aeroporto.cli.menus.flyghts;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.utils.DOMUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveFlightRunnable extends CLIMenuRunnable {

    public RemoveFlightRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        String selected;
        do {
            cli.getOut().println("Escolha o vôo a remover:");
            List<String> voosId = DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
                .map(it -> it.getAttribute("id"))
                .collect(Collectors.toList());
            cli.getOut().println(String.join(", ", voosId));

            selected = cli.getScanner().nextLine();
            if(voosId.contains(selected)) {
                cli.getOut().printf("Vôo %s removido!\n", selected);

                String finalSelected = selected;
                Main.voos.getDocumentElement().removeChild(
                    DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
                        .filter(it -> it.getAttribute("id").equalsIgnoreCase(finalSelected))
                        .findFirst().get()
                );
                //TODO write to file
            } else {
                cli.getOut().println("Vôo inválido!");
                selected = null;
            }
        } while (selected == null);
    }

    @Override
    public String getDescription() {
        return "Remover Vôo";
    }

    @Override
    public char getKey() {
        return 'R';
    }
}
