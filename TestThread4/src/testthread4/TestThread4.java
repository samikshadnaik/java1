/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread4;
class Hi3 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Hi");
            try{Thread.sleep(5000);}catch(InterruptedException e){}
        }
    }
}
class Hello3 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Hello");
            try{Thread.sleep(5000);}catch(InterruptedException e){}
        }
    }
}
public class TestThread4 {
    public static void main(String[] args){
        Hi3 obj1=new Hi3();
        Hello3 obj2=new Hello3();
        Thread t1=new Thread(obj1);
        Thread t2=new Thread(obj2);
        t1.start();
        t2.start();
    }
}