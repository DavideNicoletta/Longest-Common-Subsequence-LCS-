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

        
        int [][] table = buildTable(initial);
        ArrayList<Integer> toPrint = new ArrayList<Integer>();
        
        printList(
            rebuiltTable(initial, table[1], initial.length-1, toPrint)
        );
    }


    //Funzione di stampa dell'array
    public static void printList(ArrayList<Integer> array){
        Collections.sort(array);

        for(int x : array){
            System.out.print(x);
            System.out.print(" ");
        }
        System.out.println("");
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
        return table;

    }


    //Funzione di costruzione della ssotto-sequenza a partire dalla tabella
    public static ArrayList rebuiltTable(int [] initial, int[] array, int index, ArrayList list){
        if(index != 0){
            list.add(initial[index]);
            rebuiltTable(initial, array, array[index], list);
        }else{
            if(initial[index] < initial[index+1]){
                list.add(initial[index]);
            }
        }

        return list;

    }


}