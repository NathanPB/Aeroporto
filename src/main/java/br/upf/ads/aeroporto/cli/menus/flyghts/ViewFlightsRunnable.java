package br.upf.ads.aeroporto.cli.menus.flyghts;

import br.upf.ads.aeroporto.Main;
import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.utils.DOMUtils;
import br.upf.ads.aeroporto.utils.DateTimeUtils;
import br.upf.ads.aeroporto.utils.StringUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.Element;
import java.io.PrintStream;
import java.util.stream.Collectors;

public class ViewFlightsRunnable extends CLIMenuRunnable {

    public ViewFlightsRunnable(CLI cli) {
        super(cli);
    }

    @Override
    public void run() {
        cli.getOut().println("Listar Vôos:");
        DOMUtils.toElementStream(Main.voos.getElementsByTagName("voo"))
            .map(voo -> {
                String str = "Vôo " + voo.getAttribute("id") + ":";
                String escalasStr = DOMUtils.toElementStream(voo.getElementsByTagName("local"))
                    .map(escala -> {
                        String escalaStr = "Aeroporto: " + Main.aeroportos.get(escala.getAttribute("aeroporto"));
                        if(escala.hasAttribute("chegada")) {
                            escalaStr += "\n    Chegada: " + DateTimeUtils.formatDateTime(DateTimeUtils.parseFromUniversal(escala.getAttribute("chegada")));
                        }
                        if(escala.hasAttribute("saida")) {
                            escalaStr += "\n    Saída: " + DateTimeUtils.formatDateTime(DateTimeUtils.parseFromUniversal(escala.getAttribute("saida")));
                        }
                        return escalaStr;
                    })
                    .map("  "::concat)
                    .collect(Collectors.joining("\n"));
                return str + "\n" + escalasStr;
            }).forEach(cli.getOut()::println);
    }

    @Override
    public String getDescription() {
        return "Listar Vôos";
    }

    @Override
    public char getKey() {
        return 'A';
    }
}
