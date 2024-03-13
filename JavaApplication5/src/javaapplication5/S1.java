package javaapplication5;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shammi
 */
public class S1 {
    public static void sepWords1(int size1)throws IOException{
        String fname1="words_";
        String fname3=".txt";
        String fname=fname1+size1+fname3;
        File f1=new File("dictionary.txt");
        FileWriter fw1=new FileWriter(fname);
        Scanner sc1=new Scanner(f1);
        String s1="";
        int len1=8;
        while(sc1.hasNext()){
            s1=sc1.nextLine();
            len1=s1.length();
            if(len1==size1){
                System.out.println(s1);
                fw1.write(s1);
                fw1.write("\n");
            }
            
        }
        fw1.close();
    }
    public static void main(String[]args)throws IOException{
        for(int i=2;i<21;i++){
            sepWords1(i);
        }
        
        
        
        
      
    }
    
}
