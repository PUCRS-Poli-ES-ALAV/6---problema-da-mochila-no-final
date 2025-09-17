// inteiro distEdProgDina(string A, String B)
// 	m = tamanho(A);
// 	n = tamanho(B);
// 	matriz[0][0] = 0;
// 	Para i = 1 até m
// 	   matriz[i][0] = matriz[i-1][0] + 1  // soma uma I;
// 	Para j = 1 até n
// 	   matriz[0][j] = matriz[0][j-1] + 1  // Soma uma R;
// 	Para i = 1 até m
// 	   Para j = 1 até n
// 	      Se A[i] == B[j]
// 		 custoExtra = 0 //Operação M;
// 	      Senão
// 		 custoExtra = 1 //Operação S;
// 	      matriz[i][j] = Mínimo(matriz[i-1][j] +1, matriz[i][j-1] +1, 
// 				    matriz[i-1][j-1] + custoExtra];
// 	devolva matriz[m][n];
public class EditDistanceDinamica {
    public static int contador = 0;

    public static int distEdProgDina(String A, String B) {
        int m  = A.length();
        int n = B.length();
        int[][] matriz;
        contador += 7;
        matriz = new int[m+1][n+1];
        contador += 4;
        matriz[0][0] = 0;
        contador += 3;

        contador += 1;
        for(int i = 1; i <= m; i++) {
            contador += 1;
            matriz[i][0] = matriz[i-1][0] + 1;
        }
        contador += 1;
        for(int i = 1; i <= n; i++) {
            matriz[0][i] = matriz[0][i-1] + 1;

            
        }
        
        int custoExtra;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(A.charAt(i -1) == B.charAt(j-1)) {custoExtra = 0;}
                else {
                    custoExtra = 1;
                }
                int temp = Math.min(matriz[i-1][j] +1, matriz[i][j-1] +1);
                matriz[i][j] = Math.min(temp, matriz[i-1][j-1] + custoExtra);
            }
        }
        return matriz[m][n];
    }

    public static void main(String args[]) {
               contador = 0;
        String S = "bola";
        String T = "bala";
        System.out.println(S + " - "+ T + " : " + distEdProgDina(S, T) + " contador: " + contador);  

            contador = 0;

        S = "Casablanca";
        T = "Portentoso";
        System.out.println(S + " - "+ T + " : " + distEdProgDina(S, T) + " contador: " + contador);  

    }
}