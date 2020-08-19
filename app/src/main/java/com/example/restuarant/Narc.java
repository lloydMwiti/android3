package com.example.restuarant;

public  class Narc {

        public static boolean isNarcissistic(int n) {
            boolean is;
            int sum=0;
            int temp=n;
            while(n > 0){
                int remember=n %10;
                sum=sum+(remember * remember *remember);
                n=n/10;
            }
            if(temp == sum){
                is=true;
            }else{
                is=false;
            }
            return is;
        }

        public static void main(String[] args) {
            int query=370;
            System.out.println("Is "+query+" narcissistic "+isNarcissistic(query));
        }

}
