import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.inicializarTabuleiro();
        tabuleiro.imprimirTabuleiro();
        String nomeEmbarcacao = "PORTA_AVIOES";
        Embarcacao embarcacao = Embarcacao.valueOf(nomeEmbarcacao);
        Resultado resultado = new Resultado(embarcacao,7,4,11,4);
        tabuleiro.inserirCaractere(embarcacao.getCodigo(),resultado);
        tabuleiro.imprimirTabuleiro();

    }
}