import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {
    public List<Resultado> lerArquivo(String nomeArquivo) {
        List<Resultado> resultados = new ArrayList<>();
        Scanner scanner = null;
        try {
            File file = new File(nomeArquivo);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");
                if (partes.length == 5) {
                    String nomeEmbarcacao = partes[0];
                    int linhaInicio = Integer.parseInt(partes[1]);
                    int colunaInicio = Integer.parseInt(partes[2]);
                    int linhaFim = Integer.parseInt(partes[3]);
                    int colunaFim = Integer.parseInt(partes[4]);

                    // Validação dos dados
                    if (!Embarcacao.isValid(nomeEmbarcacao)) {
                        System.err.println("Nome de embarcação inválido: " + nomeEmbarcacao);
                        continue;
                    }
                    if (!Tabuleiro.isValidCoordinate(linhaInicio, colunaInicio) || !Tabuleiro.isValidCoordinate(linhaFim, colunaFim)) {
                        System.err.println("Coordenadas inválidas: " + linhaInicio + ", " + colunaInicio + " to " + linhaFim + ", " + colunaFim);
                        continue;
                    }
                    Embarcacao embarcacao = Embarcacao.valueOf(nomeEmbarcacao);
                    Resultado resultado = new Resultado(embarcacao, linhaInicio, colunaInicio, linhaFim, colunaFim);
                    resultados.add(resultado);
                } else {
                    System.err.println("Linha mal formatada: " + linha);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(nomeArquivo + " não encontrado:");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return resultados;
    }
}
