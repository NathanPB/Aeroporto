package br.upf.ads.aeroporto.cli.menus.flyghts.flightRange;

import br.upf.ads.aeroporto.cli.CLI;
import br.upf.ads.aeroporto.cli.CLIMenuRunnable;
import br.upf.ads.aeroporto.utils.DateTimeReader;
import br.upf.ads.aeroporto.utils.DateTimeUtils;
import org.w3c.dom.Element;

import java.util.Date;

public class EditRangeArrivalRunnable extends CLIMenuRunnable {
    private Element range;

    public EditRangeArrivalRunnable(CLI cli, Element range) {
        super(cli);
        this.range = range;
    }

    @Override
    public void run() {
        cli.getOut().println("Esta escala tem horário de chegada? [S/n]");
        if(cli.getScanner().nextLine().equalsIgnoreCase("s")) {
            Date date = new DateTimeReader.Builder()
                .format(DateTimeUtils.DATETIME_FORMAT)
                .cli(cli)
                .build().read();
            range.setAttribute("chegada", DateTimeUtils.DATETIME_UNIVERSAL_FORMAT.format(date));
        } else {
            range.removeAttribute("chegada");
        }
    }

    @Override
    public String getDescription() {
        return "Editar Chegada";
    }

    @Override
    public char getKey() {
        return 'C';
    }
}
