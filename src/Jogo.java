import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro1;
    private Tabuleiro tabuleiro2;
    private boolean vezJogador1;

    public Jogo(String arquivoJ1, String arquivoJ2) {
        this.tabuleiro1 = new Tabuleiro();
        this.tabuleiro2 = new Tabuleiro();
        carregarTabuleiro(arquivoJ1, tabuleiro1);
        carregarTabuleiro(arquivoJ2, tabuleiro2);
        this.vezJogador1 = true; // O jogador 1 começa
    }

    private void carregarTabuleiro(String arquivo, Tabuleiro tabuleiro) {
        LeitorArquivo leitor = new LeitorArquivo();
        List<Resultado> resultados = leitor.lerArquivo(arquivo);
        for (Resultado resultado : resultados) {
            Embarcacao embarcacao = resultado.getEmbarcacao();
            tabuleiro.inserirEmbarcacao(resultado, embarcacao.getCodigo());
        }
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println((vezJogador1 ? "J1" : "J2") + "> ");
            try {
                int linha = scanner.nextInt();
                int coluna = scanner.nextInt();
                if (!Tabuleiro.isValidCoordinate(linha, coluna)) {
                    System.out.println("JOGADA INVALIDA");
                    continue;
                }
                Tabuleiro tabuleiroAtual = vezJogador1 ? tabuleiro2 : tabuleiro1;
                // Verifica se a posição já foi atingida
                if (tabuleiroAtual.posicaoAtingida(linha, coluna)) {
                    System.out.println("TIRO JA EXECUTADO");
                    continue;
                }
                char resultado = tabuleiroAtual.getCaractere(linha, coluna);
                if (resultado == '~') {
                    System.out.println("AGUA");
                    vezJogador1 = !vezJogador1; // Passa a vez para o outro jogador
                } else if (resultado == ' ') {
                    System.out.println("TIRO JA EXECUTADO");
                } else {
                    System.out.println("ACERTOU");
                    char codigoEmbarcacao = resultado;
                    tabuleiroAtual.setCaractere(linha, coluna, ' '); // Marca o tiro no tabuleiro
                    if (tabuleiroAtual.embarcacaoAfundada(codigoEmbarcacao)) {
                        System.out.println("AFUNDOU " + Embarcacao.getByCodigo(codigoEmbarcacao).getNome());
                        if (tabuleiroAtual.todasEmbarcacoesAfundadas()) {
                            System.out.println("FIM DE JOGO");
                            System.out.println("VENCEDOR: Jogador " + (vezJogador1 ? "1" : "2"));
                            break;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("JOGADA INVALIDA");
                scanner.nextLine(); // Descarta a entrada inválida
            }
        }
        scanner.close();
    }
}
