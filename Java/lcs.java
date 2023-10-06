import java.util.Scanner;
import java.io.*;

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
        int [][] C = new int[m + 1][n + 1];

        char [] firstString = first.toCharArray();
        char [] secondString = second.toCharArray();
        
        
        //Costruzione tabella 

        for(int i = 0; i < m+1; i ++){
            for(int j = 0; j < n+1; j++){
                if((i == 0 && j == 0) || (i == 0 && j != 0) || (i != 0 && j == 0)){
                    C[j][i] = 0;
                }else{
                    if(firstString[i-1] == secondString[j-1]){
                        C[j][i] = C[j-1][i-1] + 1;
                    }else{
                        if(C[j][i-1] > C[j-1][i]){
                            C[j][i] = C[j][i-1];
                        }else{
                            C[j][i] = C[j-1][i];
                        }
                        
                    }
                }
                
            }
        }

        for(int i = 0; i < m+1; i ++){
            for(int j = 0; j < n+1; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println(inverti(getLCS(C, m, n, firstString, secondString)));
        tsr.close();

    }



    public static String getLCS(int tabella[][], int m, int n, char first[], char second[]){
        String LCS = "";
        if(m == 0 && n == 0){
            System.out.println("Caso base");
            return "";
        }else{
            System.out.println("Caso ricorsivo");
            if(tabella[m][n] == tabella[m-1][n] && tabella[m][n] == tabella[m][n-1]){
                if(first[m - 1] == second[n - 1]){
                    System.out.println("Caso ricorsivo primo ramo");

                    System.out.println("Valore cella: " + tabella[m][n]);
                    System.out.println("Valore lettera su m: " + first[m-1] + 
                            "Valore lettera su n: " + second[n-1] );

                    LCS = first[m-1] + getLCS(tabella, m-1, n-1, first, second);
                }else{
                    System.out.println("Caso ricorsivo secondo ramo");

                    System.out.println("Valore cella: " + tabella[m][n]);
                    System.out.println("Valore lettera su m: " + first[m-1] + 
                            "Valore lettera su n: " + second[n-1] );

                    getLCS(tabella, m-1, n, first, second);
                }
            }else{
                    if(first[m-1] == second[n-1]){
                        System.out.println("Caso ricorsivo terzo ramo");

                        System.out.println("Valore cella: " + tabella[m][n]);
                        System.out.println("Valore lettera su m: " + first[m-1] + 
                            "Valore lettera su n: " + second[n-1] );

                        LCS = first[m-1] + getLCS(tabella, m-1, n-1, first, second);
                    }else{
                        if(tabella[m-1][n] >= tabella[m][n-1]){
                            System.out.println("Caso ricorsivo quarto ramo");

                            System.out.println("Valore cella: " + tabella[m][n]);
                            System.out.println("Valore lettera su m: " + first[m-1] + 
                            "Valore lettera su n: " + second[n-1] );

                            getLCS(tabella, m-1, n, first, second);
                        }else{
                            getLCS(tabella, m, n-1, first, second);
                        }
                    }
            }

        }
        return LCS;
    }


    public static String inverti(String string){
        char support[] = string.toCharArray();
        String newString = "";
        for(int i = support.length - 1; i >= 0; i--){
            newString += support[i];
        }
        return newString;
    }


}