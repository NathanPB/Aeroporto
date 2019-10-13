package br.upf.ads.aeroporto.utils;

import br.upf.ads.aeroporto.cli.CLI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeReader {
    private Date min;
    private Date max;
    private String message;
    private CLI cli;
    private SimpleDateFormat format;

    private DateTimeReader(Date min, Date max, String message, CLI cli, SimpleDateFormat format) {
        this.min = min;
        this.max = max;
        this.message = message;
        this.cli = cli;
        this.format = format;
    }

    public Date getMin() {
        return min;
    }

    public Date getMax() {
        return max;
    }

    public String getMessage() {
        return message.replaceAll("%FORMAT_PATTERN%", format.toLocalizedPattern());
    }

    public CLI getCli() {
        return cli;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setMin(Date min) {
        this.min = min;
    }

    public void setMax(Date max) {
        this.max = max;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCli(CLI cli) {
        this.cli = cli;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    public Date read() {
        Date date = null;

        do {
            try {
                cli.getOut().println(message);
                date = format.parse(cli.getScanner().nextLine());
                if(date.compareTo(min) < 0 || date.compareTo(max) > 0) {
                    date = null;
                }
            } catch (ParseException ex) {
                cli.getOut().println("Formato de Data inválido! Use " + format.toLocalizedPattern());
            }
        } while (date == null);

        return date;
    }

    public static class Builder {
        private Date min = new Date(0);
        private Date max = new Date(Long.MAX_VALUE);
        private String message = "Formato de Data inválido! Use %FORMAT_PATTERN%";
        private CLI cli;
        private SimpleDateFormat format;

        public Builder min(Date min) {
            this.min = min;
            return this;
        }

        public Builder max(Date max) {
            this.max = max;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder cli(CLI cli) {
            this.cli = cli;
            return this;
        }

        public Builder format(SimpleDateFormat format) {
            this.format = format;
            return this;
        }

        public DateTimeReader build() {
            assert cli != null;
            assert format != null;

            return new DateTimeReader(min, max, message, cli, format);
        }
    }
}
