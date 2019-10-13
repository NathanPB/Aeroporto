package br.upf.ads.aeroporto.cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CLI {

    private PrintStream out;
    private InputStream in;
    private Scanner scanner;

    public CLI(InputStream in, PrintStream out) {
        this.out = out;
        this.in = in;
        this.scanner = new Scanner(in);
    }

    public PrintStream getOut() {
        return out;
    }

    public InputStream getIn() {
        return in;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
