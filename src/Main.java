import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        String nomeEmbarcacao = "PORTA_AVIOES";
        Embarcacao portaAviao = Embarcacao.valueOf(nomeEmbarcacao);
        Resultado resultadoA = new Resultado(portaAviao,7,4,11,4);
        Resultado resultadoB = new Resultado(Embarcacao.SUBMARINO,7,4,7,6);
        tabuleiro.imprimirTabuleiro();
        System.out.println("----------------------------");
        tabuleiro.inserirEmbarcacao(resultadoA,resultadoA.getEmbarcacao().getCodigo());
        tabuleiro.imprimirTabuleiro();
        System.out.println("----------------------------");
        tabuleiro.inserirEmbarcacao(resultadoB,resultadoB.getEmbarcacao().getCodigo());
        tabuleiro.imprimirTabuleiro();
    }
}