package br.upf.ads.aeroporto.utils;

import br.upf.ads.aeroporto.Main;
import org.w3c.dom.Element;

public class StringUtils {
    public static String capitalize(String s) {
        return s.substring(1, 1).toUpperCase() + s.substring(1);
    }

    public static String rangeToString(Element range) {
        String escalaStr = "Aeroporto: " + Main.aeroportos.get(range.getAttribute("aeroporto"));
        if(range.hasAttribute("chegada")) {
            escalaStr += "\n    Chegada: " + DateTimeUtils.formatDateTime(DateTimeUtils.parseFromUniversal(range.getAttribute("chegada")));
        }
        if(range.hasAttribute("saida")) {
            escalaStr += "\n    Saída: " + DateTimeUtils.formatDateTime(DateTimeUtils.parseFromUniversal(range.getAttribute("saida")));
        }
        return escalaStr;
    }
}
