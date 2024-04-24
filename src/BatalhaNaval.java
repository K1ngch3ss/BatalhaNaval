public class BatalhaNaval {
    public static void main(String[] args) {
        String arquivoJ1 = "j1.txt";
        String arquivoJ2 = "j2.txt";
        try {
            Jogo jogo = new Jogo(arquivoJ1, arquivoJ2);
            System.out.println("TABULEIROS CARREGADOS COM SUCESSO");
            jogo.jogar();
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o jogo: " + e.getMessage());
        }
    }
}
