package br.upf.ads.aeroporto;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.cli.menus.CLIInitialMenuRunnable;
import br.upf.ads.aeroporto.utils.DOMUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static CLI cli = new CLI(System.in, System.out);
    public static CLIMenuRunnable initialMenu = new CLIInitialMenuRunnable(cli);

    public static Document voos;
    public static Map<String, String> aeroportos = new HashMap<>();

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            voos = factory.newDocumentBuilder().parse("voos.xml");
            DOMUtils.toStream(factory.newDocumentBuilder().parse("aeroportos.xml").getElementsByTagName("aeroporto"))
                .filter(it -> it instanceof Element)
                .map(it -> (Element) it)
                .forEach(it -> aeroportos.put(it.getAttribute("id"), it.getFirstChild().getTextContent()));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        while(true) initialMenu.run();
    }
}
