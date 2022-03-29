package Recursions.BackTracking;

import java.util.ArrayList;

public class FindAllSubSets {
    
    public static void main(String[] args) {
        
        ArrayList<String> subsets = RecursiveSubSets("", "abc");
        System.out.println(subsets);


        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = linearSubsets(arr);

        for(ArrayList<Integer> list: result){
            System.out.println(list);
        }



    }

    public static ArrayList<String> RecursiveSubSets(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> emptylist = new ArrayList<String>();
            if(!p.equals("")) emptylist.add(p);
            return emptylist;
        }

        char first = up.charAt(0);

        ArrayList<String> considered = RecursiveSubSets(p + first, up.substring(1));
        ArrayList<String> unconsidered = RecursiveSubSets(p, up.substring(1));
        

        considered.addAll(unconsidered);
        return considered;
    }

    public static ArrayList<ArrayList<Integer>> linearSubsets(int[] arr){
        
        ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();

        outer.add(new ArrayList<>());

        for(int num: arr){

            int n_outer = outer.size();

            for(int i = 0; i < n_outer; i++){
               
                ArrayList<Integer> currentList = new ArrayList<Integer>();
                currentList.addAll(outer.get(i));
                currentList.add(num);

                outer.add(currentList);


            }


        }

        return outer;
    }
}
