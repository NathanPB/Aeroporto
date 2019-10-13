package br.upf.ads.aeroporto.cli;

public abstract class CLIMenuRunnable {
    protected CLI cli;

    public CLIMenuRunnable(CLI cli) {
        this.cli = cli;
    }

    public abstract String getInitialDialog();
    public abstract String getDescription();
    public abstract char getKey();
    public void run() {
        cli.getOut().println(getInitialDialog());
    }
}
