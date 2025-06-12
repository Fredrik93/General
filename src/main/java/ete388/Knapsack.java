package ete388;

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

    }
    void calculateValue(List<int []> listOfItems) {
        //we need an arraylist otherwise the List items are immutable
        List<int[]> list = new ArrayList<>(listOfItems);

        int capacity = 0;
        int highestValue = 0;
        int savedIndices =0;
        int index =0;
        int currentValue = 0;
        int knapsackCapacityConstant = list.getFirst()[0];
        int knapSackCapacity = knapsackCapacityConstant;
        int listSize = list.getFirst()[1];
        // remove the first list item
        list.removeFirst();
        for(int[] i : list) {

            // we could use i1[1] to get the size of the list but we can also just use list.size to iterate
            //Iterate over each row, add first entry to capacity int, and add value to totalValue int
            System.out.println("list items: value: " + i[0] + " weight: " + i[1]);
            //Stop when capacity is equal to or larger than knapsackCap
            if(capacity <= knapSackCapacity) {
                currentValue += i[0];
                capacity += i[1];
                knapSackCapacity -= capacity;
                System.out.println("current capacity: " + capacity + " currentValue: " + currentValue + " and total knapSackCapacity: " + knapSackCapacity);
                highestValue += currentValue;
                index ++;
                savedIndices = index;

                //save the indices where the values were found, together with the total value and the amount of indices
                // keep iterating until list is done
            }else {
                System.out.println("no more space in knapsack: " + knapSackCapacity + " currentValue: " + currentValue);
            }
            System.out.println("saving highest value" + highestValue + " and indices " + savedIndices);
            knapSackCapacity = knapsackCapacityConstant;
        }

    }
}