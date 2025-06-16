package se.general.projects;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * test input
 * 5 3 (Knapsack has capacity of 5 and there will be three rows underneath this one to examine)
 * 1 5 (row 1, value 1 weight 5)
 * 10 5 (row 2, value 10 weight 5)
 * 100 5  (row 3, value 100 weight so we want this one, i.e., index #2 )
 * 6 4 (start over, knapsack has cap of 6 and we are examining four rows below this one
 * 5 4 (row 1, index 0)
 * 4 3 (row 2, index 1)
 * 3 2 (r3, i2)
 * 2 1  (r4, i3)
 *****
 * * Test Output:
 * 1 (Found one item)
 * 2 (This item is on index 2)
 * 3 (Found three items)
 * 1 2 3 ( the items are on index 1 ,2 and 3)
 * explanation output:
 *
 */
public class Knapsack {
    public static void main(String[] args) {

        int [] i1 =  {5,3};
        int [] i2 =  {1,5};
        int [] i3 =  {10,5};
        int [] i4 =  {100,5};

        Knapsack k = new Knapsack();
        k.calculateValue(List.of(i1,i2,i3,i4));

//        int [] i1 =  {6,4};
//        int [] i2 =  {5,4};
//        int [] i3 =  {4,3};
//        int [] i4 =  {3,2};
//        int [] i5 =  {2,1};
//
//        Knapsack k = new Knapsack();
//        k.calculateValue(List.of(i1,i2,i3,i4,i5));
    }
    void calculateValue(List<int []> listOfItems) {
        //we need an arraylist otherwise the List items are immutable
        List<int[]> list = new ArrayList<>(listOfItems);
        int knapsackCapacity = list.getFirst()[0];
        int amountOfRowsToIterateOver = list.getFirst()[1];
        int currentValue =0;
        int currentWeight=0;
        list.removeFirst();
        for(int i = 0; i<list.size(); i++)
        {
            int value = list.get(i)[0];
            int weight = list.get(i)[1];

            if(currentWeight+weight <= knapsackCapacity){
                currentValue += value;
                currentWeight += weight;

            } else if(value > currentValue){
                currentValue = value;
                currentWeight = weight;
            }
        }
        System.out.println("value : " + currentValue + " weight: " + currentWeight);
    }
}
