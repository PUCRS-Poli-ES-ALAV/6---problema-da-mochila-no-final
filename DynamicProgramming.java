public class DynamicProgramming {
    public static int inst = 0;
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
        inst += 5;
        inst += 3;
        for (int i = 1; i <= N; i++) {

            inst += 3;
            for (int j = 1; j <= C; j++) {
                inst += 3;
                if (itens[i].peso <= j) {
                    inst += 13;
                    maxTab[i][j] = Math.max(maxTab[i - 1][j],
                            itens[i].valor + maxTab[i - 1][j - itens[i].peso]);
                } else {
                    inst+= 4;
                    maxTab[i][j] = maxTab[i - 1][j];
                }
                inst++;
            }
            inst++;
        }
        return maxTab[N][C];
    }

    public static void main(String[] args) {
        inst = 0;
        Item[] itens = new Item[11];
        itens[0] = null;
        itens[1] = new Item(23, 92);
        itens[2] = new Item(31, 57);
        itens[3] = new Item(29, 49);
        itens[4] = new Item(44, 68);
        itens[5] = new Item(53, 60);
        itens[6] = new Item(38, 43);
        itens[7] = new Item(63, 67);
        itens[8] = new Item(85, 84);
        itens[9] = new Item(89, 87);
        itens[10] = new Item(82, 72);
        System.out.println(backPackPD(10, 165, itens));
        System.out.println("Total de operacoes: " + inst);
    }
}
