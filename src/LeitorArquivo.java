import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {
    public List<Resultado> lerArquivo(String nomeArquivo) {
        List<Resultado> resultados = new ArrayList<>();
        try {
            File file = new File(nomeArquivo);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");
                if (partes.length == 5) {
                    String nomeEmbarcacao = partes[0];
                    int linhaInicio = Integer.parseInt(partes[1]);
                    int colunaInicio = Integer.parseInt(partes[2]);
                    int linhaFim = Integer.parseInt(partes[3]);
                    int colunaFim = Integer.parseInt(partes[4]);

                    Embarcacao embarcacao = Embarcacao.valueOf(nomeEmbarcacao);

                    Resultado resultado = new Resultado(embarcacao,linhaInicio,colunaInicio,linhaFim,colunaFim);
                    resultados.add(resultado);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println(nomeArquivo+ "não encontrado:");
        }
        return resultados;
    }
}

