public class Tabuleiro {
    private char[][] matriz;
    private static int tamanho = 15;

    // Construtor
    public Tabuleiro() {
        matriz = new char[tamanho][tamanho];
        // Inicializa a matriz com espaços em branco
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = '~';
            }
        }
    }

    // Método para definir um caractere em uma posição específica
    public void setCaractere(int linha, int coluna, char caractere) {
        if (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho) {
            matriz[linha][coluna] = caractere;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    // Método para obter um caractere de uma posição específica
    public char getCaractere(int linha, int coluna) {
        if (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho) {
            return matriz[linha][coluna];
        } else {
            System.out.println("Posição inválida!");
            return ' ';
        }
    }
    public static boolean isValidCoordinate(int linha, int coluna) {
        return (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho);
    }
    // Método para imprimir o tabuleiro
    public void imprimirTabuleiro() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void inserirEmbarcacao(Resultado resultado, char novoCaractere) {
        if (resultado.getLinhaInicio() >= 0 && resultado.getLinhaInicio() < tamanho && resultado.getColunaInicio() >= 0 && resultado.getColunaInicio() < tamanho &&
                resultado.getLinhaFim() >= 0 && resultado.getLinhaFim() < tamanho && resultado.getColunaFim() >= 0 && resultado.getColunaFim() < tamanho) {
            for (int i = resultado.getLinhaInicio(); i <= resultado.getLinhaFim(); i++) {
                for (int j = resultado.getColunaInicio(); j <= resultado.getColunaFim(); j++) {
                    if (matriz[i][j] == '~') {
                        matriz[i][j] = novoCaractere;
                    } else {
                        System.out.println("Posição já ocupada!");
                        return;
                    }
                }
            }
        } else {
            System.out.println("Posição inválida!");
        }
    }
    // Método para verificar se uma embarcação foi afundada
    public boolean embarcacaoAfundada(char codigo) {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (matriz[i][j] == codigo) {
                    return false; // Ainda há partes da embarcação no tabuleiro
                }
            }
        }
        return true; // Não há mais partes da embarcação no tabuleiro
    }

    // Método para verificar se todas as embarcações foram afundadas
    public boolean todasEmbarcacoesAfundadas() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (matriz[i][j] != '~' && matriz[i][j] != ' ') {
                    return false; // Ainda há pelo menos uma embarcação no tabuleiro
                }
            }
        }
        return true; // Não há mais embarcações no tabuleiro
    }
    public boolean posicaoAtingida(int linha, int coluna) {
        return matriz[linha][coluna] == ' ';
    }

}
