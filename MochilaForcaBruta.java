public class MochilaForcaBruta {
    public static int inst = 0;
    static class Item {
        int peso;
        int valor;
        Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static int mochilaForcaBruta(Item[] itens, int N, int C) {
        return mochilaRec(itens, N, C, 0);
    }

    private static int mochilaRec(Item[] itens, int N, int C, int i) {
        inst += 3;
        if (i == N) return 0;

        int semAtual = mochilaRec(itens, N, C, i + 1);
        inst += 3;
        
        if (itens[i].peso > C) {
            inst += 4;
            return semAtual;
        }
        
        int comAtual = itens[i].valor + mochilaRec(itens, N, C - itens[i].peso, i + 1);
        inst += 11;
        return Math.max(semAtual, comAtual);
    }

    public static void main(String[] args) {
        inst = 0;
        Item[] itens = {
            new Item(23, 92),
            new Item(31, 57),
            new Item(29, 49),
            new Item(44, 68),
            new Item(53, 60),
            new Item(38, 43),
            new Item(63, 67),
            new Item(85, 84),
            new Item(89, 87),
            new Item(82, 72)
        };
        int capacidade = 165;
        int N = itens.length;

        System.out.println("Valor máximo: " + mochilaForcaBruta(itens, N, capacidade));
        System.out.println("Total operacoes: " + inst);
    }
}
