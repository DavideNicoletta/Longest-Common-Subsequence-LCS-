import java.util.Scanner;

class lcs{
    public static void main(String [] args){
        Scanner tsr = new Scanner(System.in);

        System.out.println("Inserisci la prima stringa:");
        String first = tsr.nextLine();
        System.out.println("");

        System.out.println("Insersci la seconda stringa:");
        String second = tsr.nextLine();
        System.out.println("");
        
        int m = first.length();
        int n = second.length();
        char [] firstString = first.toCharArray();
        char [] secondString = second.toCharArray();

        System.out.println(reverse(rebuildTable(
            buildTable(m, n, firstString, secondString), 
                m, n, firstString, secondString, "")));
        tsr.close();

    }



    public static String rebuildTable(int table[][], int m, int n, 
            char first[], char second[], String LCS){
        if(m == 0 && n == 0){
            return "";
        }else{
            //cella a sinistra e sopra uguali 
            if(table[m][n] == table[m - 1][n] && table[m][n] == table[m][n - 1]){
                if(first[m - 1] == second[n - 1]){
                    LCS = first[m - 1] + 
                        rebuildTable(table, m - 1, n - 1, first, second, LCS);
                }else{
                    LCS = rebuildTable(table, m - 1, n, first, second, LCS);
                }
            }else{
                    if(first[m - 1] == second[n - 1]){
                        LCS = first[m - 1] + rebuildTable(table, m - 1, n - 1, first, 
                        second, LCS);
                    }else{
                        if(table[m - 1][n] >= table[m][n - 1]){
                            LCS = rebuildTable(table, m - 1, n, first, second, LCS);
                        }else{
                            LCS = rebuildTable(table, m, n - 1, first, second, LCS);
                        }
                    }
            }

        }
        return LCS;
    }


    public static int[][] buildTable(int m, int n, char firstString[], char secondString[]){
        int [][] C = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i ++){
            for(int j = 0; j < n + 1; j++){
                if((i == 0 && j == 0) || (i == 0 && j != 0) || (i != 0 && j == 0)){
                    C[i][j] = 0;
                }else{
                    if(firstString[i - 1] == secondString[j - 1]){
                        C[i][j] = C[i-1][j-1] + 1;
                    }else{
                        if(C[i][j - 1] > C[i - 1][j]){
                            C[i][j] = C[i][j - 1];
                        }else{
                            C[i][j] = C[i - 1][j];
                        }
                        
                    }
                }
                
            }
        }
        return C;
    }

    public static String reverse(String string){
        char support[] = string.toCharArray();
        String newString = "";
        for(int i = support.length - 1; i >= 0; i--){
            newString += support[i];
        }
        return newString;
    }


}