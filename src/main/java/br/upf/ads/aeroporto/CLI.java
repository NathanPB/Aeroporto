package br.upf.ads.aeroporto;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CLI {

    private PrintWriter out;
    private InputStream in;
    private Scanner scanner;

    public CLI(InputStream in, PrintWriter out) {
        this.out = out;
        this.in = in;
        this.scanner = new Scanner(in);
    }

    public void showMenu() {
        out.println("");

    }

    public PrintWriter getOut() {
        return out;
    }

    public InputStream getIn() {
        return in;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
