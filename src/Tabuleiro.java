public class Tabuleiro {
    private char[][] matriz;
    private static int tamanhoMax = 16;
    private static int tamanhoMin = 1;

    public Tabuleiro() {
        matriz = new char[tamanhoMax][tamanhoMax];
        // Inicializa a matriz com espaços em branco
        for (int i = tamanhoMin; i < tamanhoMax; i++) {
            for (int j = tamanhoMin; j < tamanhoMax; j++) {
                matriz[i][j] = '~';
            }
        }
    }
    public void setCaractere(int linha, int coluna, char caractere) {
        if (linha >= tamanhoMin && linha < tamanhoMax && coluna >= tamanhoMin && coluna < tamanhoMax) {
            matriz[linha][coluna] = caractere;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public char getCaractere(int linha, int coluna) {
        if (linha >= tamanhoMin && linha < tamanhoMax && coluna >= tamanhoMin && coluna < tamanhoMax) {
            return matriz[linha][coluna];
        } else {
            System.out.println("Posição inválida!");
            return ' ';
        }
    }

    public static boolean isValidCoordinate(int linha, int coluna) {
        return (linha >= tamanhoMin && linha < tamanhoMax && coluna >= tamanhoMin && coluna < tamanhoMax);
    }

    public void imprimirTabuleiro() {
        for (int i = tamanhoMin; i < tamanhoMax; i++) {
            for (int j = tamanhoMin; j < tamanhoMax; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Boolean confirmarEspacoLivre(Resultado result) throws EspacoNaoLivreException {
        // Verifica se as coordenadas de início e fim estão dentro dos limites do tabuleiro
        if (result.getColunaInicio() < tamanhoMin || result.getLinhaInicio() >= tamanhoMax  || result.getColunaFim() < tamanhoMin || result.getLinhaFim() >= tamanhoMax  ||
                result.getColunaFim() < tamanhoMin || result.getColunaFim() >= tamanhoMax  || result.getLinhaFim() < tamanhoMin || result.getLinhaFim() >= tamanhoMax ) {
            throw new EspacoNaoLivreException("Coordenadas fora do tabuleiro.");
        }

        // Percorre o intervalo entre as coordenadas de início e fim
        for (int i = result.getLinhaInicio(); i <= result.getLinhaFim(); i++) {
            for (int j = result.getColunaInicio(); j <= result.getColunaFim(); j++) {
                // Verifica se a posição no tabuleiro está ocupada ou se as posições adjacentes estão ocupadas
                if (matriz[i][j] != '~' || (i > 0 && matriz[i-1][j] != '~') || (j > 0 && matriz[i][j-1] != '~') ||
                        (i < tamanhoMax-1 && matriz[i+1][j] != '~') || (j < tamanhoMax-1 && matriz[i][j+1] != '~')) {
                    throw new EspacoNaoLivreException("Posição ocupada ou posições adjacentes ocupadas.");
                }
            }
        }
        // Se todas as posições e suas adjacentes estiverem livres, retorna true
        return true;
    }

    public void inserirEmbarcacao(Resultado result,char caractere) throws EspacoNaoLivreException {
        // Verifica se o espaço está livre usando o método confirmarEspacoLivre
        if (confirmarEspacoLivre(result)) {
            // Percorre o intervalo entre as coordenadas de início e fim
            for (int i = result.getLinhaInicio(); i <= result.getLinhaFim(); i++) {
                for (int j = result.getColunaInicio(); j <= result.getColunaFim(); j++) {
                    // Insere o caractere nos espaços livres
                    matriz[i][j] = caractere;
                }
            }
        } else {
            throw new EspacoNaoLivreException("Espaço não está livre ou adjacente a um espaço ocupado, caractere não inserido.");
        }
    }

    // Método para verificar se uma embarcação foi afundada
    public boolean embarcacaoAfundada(char codigo) {
        for (int i = tamanhoMin; i < tamanhoMax; i++) {
            for (int j = 0; j < tamanhoMax; j++) {
                if (matriz[i][j] == codigo) {
                    return false; // Ainda há partes da embarcação no tabuleiro
                }
            }
        }
        return true; // Não há mais partes da embarcação no tabuleiro
    }

    // Método para verificar se todas as embarcações foram afundadas
    public boolean todasEmbarcacoesAfundadas() {
        for (int i = tamanhoMin; i < tamanhoMax; i++) {
            for (int j = tamanhoMin; j < tamanhoMax; j++) {
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
