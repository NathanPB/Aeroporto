package br.upf.ads.aeroporto.cli.menus.flyghts;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.utils.DOMUtils;
import br.upf.ads.aeroporto.utils.ReaderUtils;

public class RemoveFlightRunnable extends CLIMenuRunnable {

    public RemoveFlightRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        String selected = ReaderUtils.chooseFlight(cli, "Escolha o vôo a remover:");
        Main.voos.getDocumentElement().removeChild(
            DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
                .filter(it -> it.getAttribute("id").equalsIgnoreCase(selected))
                .findFirst().get()
        );
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
