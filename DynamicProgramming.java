public class DynamicProgramming {

    static class Item {
        int peso;
        int valor;
        Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static int backPackPD(int N, int C, Item[] itens) {
        int[][] maxTab = new int[N + 1][C + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (itens[i].peso <= j) {
                    maxTab[i][j] = Math.max(maxTab[i - 1][j],
                            itens[i].valor + maxTab[i - 1][j - itens[i].peso]);
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }
        return maxTab[N][C];
    }

    public static void main(String[] args) {
        Item[] itens = new Item[5];
        itens[0] = null;
        itens[1] = new Item(5, 2);
        itens[2] = new Item(2, 4);
        itens[3] = new Item(2, 2);
        itens[4] = new Item(1, 3);
        System.out.println(backPackPD(4, 7, itens));
    }
}
