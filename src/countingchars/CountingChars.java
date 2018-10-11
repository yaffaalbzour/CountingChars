/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingchars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author yaffa
 */
public class CountingChars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the path of the text file you want to read, please.");
        String file_name=in.nextLine(); 
        System.out.println("Enter a charecter to find out the number of its occurence, please.");
        String find=in.next();
        char find_char = find.charAt(0);
        String text=null;
        try (BufferedReader br = new BufferedReader(new FileReader(file_name))){
            text = br.readLine();
        }catch(IOException e){}
        Long itr_start= System.nanoTime();
        System.out.println("The number of occurrenes of the input character \""+
                    find_char+"\" in the text file \""+file_name+"\" is: "+
                ItrCountingChar(text, find_char));
        Long itr_stop = System.nanoTime();
        Long itr_runtime = itr_stop-itr_start; // The runtime
        System.out.println("The total runtime for the iterative algorithm is: "+itr_runtime);
        Long rec_start = System.nanoTime();
        System.out.println("The number of occurrenes of the input character \""+
                    find_char+"\" in the text file \""+file_name+"\" is: "+
                RecCountingChar(text, find_char, text.length()));
//        هنا اخذنا الوقت بعد ما خلصت الميثود الركيرسف وحسبنا الوقت المستغرق بنفس الطريقة السابقة وطبعناها
        Long rec_stop= System.nanoTime();
        Long rec_runtime = rec_stop - rec_start; // The runtime
        System.out.println("The total runtime for the iterative algorithm is: "+rec_runtime);
    }
//    هذه ميثود الريكيرسف
//    استقبلت النص الذي سنبحث به والحرف الذي سنبحث عنه وطول النص الاصلي
    public static int RecCountingChar(String text, char find_char, int text_len){
        if(text_len<1) return 0;
        text_len--;
        if(text.charAt(text_len)==find_char){
            return 1+RecCountingChar(text, find_char, text_len);
        }else{
            return 0 + RecCountingChar(text, find_char, text_len);
        }
    }
    public static int ItrCountingChar(String text, char find_char){
        int char_count = 0;
            for(int i =0; i<text.length()-1; i++){
                if(text.charAt(i)==find_char){
                    char_count ++;
                }
            }
            return char_count;
        
    }
}