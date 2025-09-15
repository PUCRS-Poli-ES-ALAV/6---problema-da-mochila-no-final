public class EditDistance {


    public static int getDistance(String a, String b, int i, int j) {
        int dist = 0;


        return dist;

    }

    public static void main(String[] args) {
        System.out.println(getDistance("Casablanca", "Portentoso"));  
    }
}
/*
Caso Base:
Quando ficamos sem caracteres para comparer em S ou em T. Se em ambas, o
resultado é 0. Se uma das duas, retorna o restante dos caracteres da que não
está vazia;
Casos Recursivos
Se S[i] == T[i], chame recursivamente ED(S, T, i-1, j-1) (foi match, não
precisa fazer nada nesta posição, o custo é zero.
Se não, três chamadas recursivas são necessárias:
• Substituição: ED(S, T, i-1, j-1) + 1
• Inserção: ED(S, T, i, j-1) + 1
• Remoção: ED(S, T, i-1, j) + 1
• Retorne a que resultar em menor custo
*/