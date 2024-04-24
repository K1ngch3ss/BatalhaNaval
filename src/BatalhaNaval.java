public class BatalhaNaval {
    public static void main(String[] args) {
        String arquivoJ1 = "j1.txt";
        String arquivoJ2 = "j2.txt";
        System.out.println("Bem Vindos ao Batalha Naval");
        Jogo jogo = new Jogo(arquivoJ1, arquivoJ2);
        jogo.jogar();
    }
}
