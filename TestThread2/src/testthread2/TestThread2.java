/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread2;
class Hi2 extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Hi");
            try{Thread.sleep(5000);}catch(InterruptedException e){}
        }
    }
}
class Hello2 extends Thread{
    public void run(){
         for(int i=0;i<5;i++){
            System.out.println("Hi");
            try{Thread.sleep(5000);}catch(InterruptedException e){}
         }
    }
}
public class TestThread2 {
    public static void main(String[] args) {
        Hi2 obj1=new Hi2();
        Hello2 obj2=new Hello2();
        obj1.start();
        obj2.start();
    }
    
}
