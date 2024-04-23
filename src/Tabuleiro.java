public class Tabuleiro {

    private int tamanho = 15;
    private char[][] tabuleiro;


    public Tabuleiro() {
        // Inicializa a matriz do tabuleiro com tamanho 15x15
        this.tabuleiro = new char[tamanho][tamanho];
        // Preenche o tabuleiro com o caractere 'a' de água
        inicializarTabuleiro();
    }

    // Método privado para preencher o tabuleiro com '-'
    public void inicializarTabuleiro() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                tabuleiro[i][j] = '~';
            }
        }
    }


    public Boolean confirmarEspacoLivre(Resultado resultado) {
        // Verifica se as coordenadas de início e fim estão dentro dos limites do tabuleiro
        if (resultado.getCab1() < 0  || resultado.getCab1() >= 15  || resultado.getCab2() < 0 || resultado.getCab2() >= 15 ||
        resultado.getCald1() < 0  || resultado.getCald1() >= 15  || resultado.getCald2() < 0 || resultado.getCald2() >= 15) {
            // Coordenadas fora do tabuleiro, retorna false
            return false;
        }
        // Percorre o intervalo entre as coordenadas de início e fim
        for (int i = resultado.getCab1(); i <= resultado.getCald1(); i++) {
            for (int j = resultado.getCald1(); j <= resultado.getCald2(); j++) {
                // Verifica se a posição no tabuleiro está ocupada
                if (tabuleiro[i][j] != '~') {
                    // Posição ocupada, retorna false
                    return false;
                }
            }
        }
        // Se todas as posições estiverem livres, retorna true
        return true;
    }
        public void inserirCaractere(char caractere, Resultado result) {
        // Verifica se o espaço está livre usando o método confirmarEspacoLivre
        if (confirmarEspacoLivre(result)) {
            // Percorre o intervalo entre as coordenadas de início e fim
            for (int i = result.getCab1(); i <= result.getCald1(); i++) {
                for (int j = result.getCald1(); j <= result.getCald2(); j++) {
                    // Insere o caractere nos espaços livres
                    tabuleiro[i][j] = caractere;
                }
            }
            System.out.println("Caractere inserido com sucesso!");
        } else {
            System.out.println("Espaço não está livre, caractere não inserido.");
        }
    }



    // Método para imprimir o tabuleiro no console
    public void imprimirTabuleiro() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                // Imprime o caractere na posição (i, j) do tabuleiro, seguido de um espaço
                System.out.print(tabuleiro[i][j] + " ");
            }
            // Imprime uma nova linha para separar as linhas do tabuleiro
            System.out.println();
        }
    }
}

