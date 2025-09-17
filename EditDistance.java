public class EditDistance {
    public static int contador = 0;

    public static int getDistance(String S, String T, int i, int j) {
        contador += 3;
        if (i == -1 && j == -1) {
            contador += 1;
            return 0;
        } else if (i == -1) {
            contador += 4;
            return T.length();
        } else if (j == -1) {
            contador += 4;
            return S.length();
        }
        contador += 5;
        if (S.charAt(i) == T.charAt(j)) { 
            contador += 4;
            return getDistance(S, T, i-1, j-1);
        } else {
            contador += 13;
            return Math.min(getDistance(S, T, i-1, j-1) + 1, Math.min(getDistance(S, T, i, j-1) + 1, getDistance(S, T, i-1, j) + 1));
        }

    }

    public static void main(String[] args) {
        contador = 0;
        String S = "bola";
        String T = "bala";
        System.out.println(S + " - "+ T + " : " + EditDistance.getDistance(S, T, S.length()-1, T.length()-1) + " contador: " + contador);  

            contador = 0;

        S = "Casablanca";
        T = "Portentoso";
        System.out.println(S + " - "+ T + " : " + EditDistance.getDistance(S, T, S.length()-1, T.length()-1) + " contador: " + contador);  

    }
}
/*
Caso Base:
Quando ficamos sem caracteres para comparer em S ou em T. Se em ambas, o
resultado é 0. Se uma das duas, retorna o restante dos caracteres da que não
está vazia;
Casos Recursivos
Se S[i] == T[j], chame recursivamente ED(S, T, i-1, j-1) (foi match, não
precisa fazer nada nesta posição, o custo é zero.
Se não, três chamadas recursivas são necessárias:
• Substituição: ED(S, T, i-1, j-1) + 1
• Inserção: ED(S, T, i, j-1) + 1
• Remoção: ED(S, T, i-1, j) + 1
• Retorne a que resultar em menor custo
*/