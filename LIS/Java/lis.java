import java.util.*;
import java.io.*;
class lis{
    public static void main(String args []){
        /*
        Scanner str = new Scanner(System.in);
        System.out.println("Quanti elementi vuoi inserire?");

        int numberElement = str.nextInt();
        int initial [] = new int [numberElement];

        for(int i = 0; i < numberElement; i++){
            System.out.println("Inserisci elemento " + (i + 1) + ": ");
            initial[i] = str.nextInt();
        }
        */
        
        //int initial [] = {14, 2, 4, 2, 7, 0, 13, 21, 20};
        int initial [] = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
        //int initial [] = {1, 3, 2, 7, 8};

        //printArray(initial);
        int [][] table = buildTable(initial);
        
        int [] print = rebuiltTable(table, initial, initial.length);
        
        printArray(print);
    }


    //Funzione di stampa dell'array
    public static void printArray(int [] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    //Funzione di stampa della tabella
    public static void printTable(int [][] table, int len){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < len; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    //Funzione di costruzione della tabella
    public static int [][] buildTable(int [] array){
        int len = array.length;
        int [][] table = new int [2][len];

        table[0][0] = 1;
        table[1][0] = 0;

        
        for(int i = 0; i < len; i++){
            table[0][i] = 1;
            table[1][i] = 0;
        }
 
        for(int i = 1; i < len; i++){ 
            for(int j = 0; j < i; j++){
                if(array[i] > array[j]){
                    if(table[0][i] <= table[0][j]){
                        table[0][i] = table[0][j] + 1;
                        table[1][i] = j;
                    }
                }
            }
        }
       
        printTable(table, len);
        return table;

    }


    //Funzione di costruzione della ssotto-sequenza a partire dalla tabella
    public static int [] rebuiltTable(int [][] table, int [] array, int len){
        int i = len - 1;
        int bound = table[0][i];
        int [] ret = new int[bound];
        int index = table[1][len-1];
        ret[bound - 1] = array[table[1][index]];
        bound--;
        index = table[1][index];
        do{
            ret[bound - 1] = array[table[1][index]];
            index = table[1][index];
            bound--;
        }while(index != 0);
        return ret;
    }

}