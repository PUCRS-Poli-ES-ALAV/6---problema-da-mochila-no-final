import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Mochila {

    int capacidade;
    int capUti;
    ArrayList<Bloco> blocos;
    int valorTotal;

    public Mochila(int cap) {
        this.capacidade = cap;
        this.capUti = 0;
        this.blocos = new ArrayList<>();
        this.valorTotal = 0;

    }

    public void printa() {
        for( Bloco bloco : blocos) {
            System.out.println(bloco.num + ": peso - " + bloco.peso + ", valor - " + bloco.valor);
        }
        System.out.println("Total: " + valorTotal);

    }

    public static void main(String[] args) {
        Mochila mochila = new Mochila(165);

        ArrayList<Bloco> blocos = new ArrayList<>();
        ArrayList<Integer> pesos = new ArrayList<>(Arrays.asList(23, 31, 29, 44, 53, 38, 63, 85, 89, 82));
        ArrayList<Integer> valores = new ArrayList<>(Arrays.asList(92, 57, 49, 68, 60, 43, 67, 84, 87, 72));
        
        for (int i = 0; i < pesos.size(); i++) {
            blocos.add(new Bloco("" + i, pesos.get(i), valores.get(i), valores.get(i)/pesos.get(i)));
        }

        Collections.sort(blocos, new Comparator<Bloco>(){
            @Override
            public int compare(Bloco a, Bloco b) {
                return Double.compare(a.custoBenef, b.custoBenef);
            }
        });

        for(Bloco bloco : blocos) {
            if (bloco.peso + mochila.capUti > mochila.capacidade) {
                continue;
            }
            mochila.blocos.add(bloco);
            mochila.capUti += bloco.peso;
            mochila.valorTotal += bloco.valor;
        }

        mochila.printa();

    }
}

class Bloco {
    int peso;
    int valor;
    double custoBenef;
    String num;

    public Bloco (String num, int peso, int valor, int custoBenef) {
        this.peso = peso;
        this.valor = valor;
        this.custoBenef = custoBenef;
        this.num = num;
    }
}
