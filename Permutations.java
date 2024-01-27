import java.util.Arrays;
import java.util.Scanner;

public class Permutations {


    public static long amount(String str){
        long total=1;
        for(int i=str.length();i>=1;i--){
            total*=i;
        }
        return total;
    }
    public static String swap(String str, int i, int f){
        char[] letters = str.toCharArray();
        char temp=letters[i];
        letters[i]=letters[f];
        letters[f]=temp;

        return String.copyValueOf(letters);
    }

    public static void permutate(String word, int start, int end){
        if(start==end){
            System.out.println(word);
        }

        for(int i=start;i<=end;i++){
            String swapped = swap(word,start,i);
            permutate(swapped,start+1,end);


        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String s = input.next();
        System.out.println();

        long startTime = System.nanoTime();
        permutate(s,0,s.length()-1);
        long endTime = System.nanoTime();

        double milliseconds = (double)(endTime-startTime)/1000000;
        System.out.println();
        System.out.println("Number of Combinations: "+amount(s));
        System.out.println("Time in Milliseconds: "+milliseconds);
        System.out.println("Time in Seconds: "+ milliseconds/1000.0);
    }
}
