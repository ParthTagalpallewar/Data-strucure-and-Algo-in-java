package DivideAndConquer;

import java.util.HashMap;

class FiboSeries{

    HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
    
    public static void main(String[] args) {
        
        FiboSeries fibo = new FiboSeries();
        int fiboNacci = fibo.dynamicApproach(2);
        int dandc = divideAndConquerApproach(2);
        
        System.out.println(fiboNacci);
        System.out.println(dandc);

    }

    public static int divideAndConquerApproach(int num){

        if(num < 2){
            return 1;
        }

        return divideAndConquerApproach(num-1) + divideAndConquerApproach(num-2);
    }

    public int dynamicApproach(int num){
        if(maps.containsKey(num)){
            return maps.get(num);
        }else{
            int f = 0;
            if(num < 2){
                f = num;
            }else{
                f = dynamicApproach(num-1) + dynamicApproach(num-2);
            }

            maps.putIfAbsent(num, f);
            return f;

        }
    }
}