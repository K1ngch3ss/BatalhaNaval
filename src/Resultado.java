public class Resultado {
    private Embarcacao embarcacao;
    private int cab1;
    private int cab2;
    private int cald1;
    private int cald2;


    public Resultado(Embarcacao embarcacao, int cab1, int cab2, int cald1, int cald2) {
        this.embarcacao = embarcacao;
        this.cab1 = cab1;
        this.cab2 = cab2;
        this.cald1 = cald1;
        this.cald2 = cald2;
    }

    public Embarcacao getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(Embarcacao embarcacao) {
        this.embarcacao = embarcacao;
    }

    public int getCab1() {
        return cab1;
    }

    public void setCab1(int cab1) {
        this.cab1 = cab1;
    }

    public int getCab2() {
        return cab2;
    }

    public void setCab2(int cab2) {
        this.cab2 = cab2;
    }

    public int getCald1() {
        return cald1;
    }

    public void setCald1(int cald1) {
        this.cald1 = cald1;
    }

    public int getCald2() {
        return cald2;
    }

    public void setCald2(int cald2) {
        this.cald2 = cald2;
    }
}