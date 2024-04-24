import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {
    public List<Resultado> lerArquivo(String nomeArquivo) throws Exception {
        List<Resultado> resultados = new ArrayList<>();
        Scanner scanner = null;
        int linhaCount = 0; // Inicia a contagem de linhas em 0
        try {
            File file = new File(nomeArquivo);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                linhaCount++; // Incrementa o contador de linhas no início do loop
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
                        throw new Exception("ERRO LINHA " + linhaCount + ": " + nomeArquivo);
                    }
                    if (!Tabuleiro.isValidCoordinate(linhaInicio, colunaInicio) || !Tabuleiro.isValidCoordinate(linhaFim, colunaFim)) {
                        throw new Exception("ERRO LINHA " + linhaCount + ": " + nomeArquivo);
                    }
                    if ((linhaInicio != linhaFim && colunaInicio == colunaFim) || (linhaInicio == linhaFim && colunaInicio != colunaFim)) {
                        Embarcacao embarcacao = Embarcacao.valueOf(nomeEmbarcacao.toUpperCase());
                        int tamanhoReal = Math.max(Math.abs(linhaFim - linhaInicio), Math.abs(colunaFim - colunaInicio)) + 1;
                        if (tamanhoReal != embarcacao.getTamanho()) {
                            throw new Exception("ERRO LINHA " + linhaCount + ": " + nomeArquivo);
                        }
                        Resultado resultado = new Resultado(embarcacao, linhaInicio, colunaInicio, linhaFim, colunaFim);
                        resultados.add(resultado);
                    } else {
                        throw new Exception("ERRO LINHA " + linhaCount + ": " + nomeArquivo);
                    }
                } else {
                    throw new Exception("ERRO LINHA " + linhaCount + ": " + nomeArquivo);
                }
            }
        } catch (FileNotFoundException e) {
            throw new Exception(nomeArquivo + " não encontrado:");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return resultados;
    }
}



