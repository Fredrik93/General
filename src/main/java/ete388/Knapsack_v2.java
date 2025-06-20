package se.general.projects;

import java.util.ArrayList;
import java.util.Arrays;
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
    private int itemsFound =0;
    private int [] indices = {0,0};
    public static void main(String[] args) {


    }
    int calculateValue(List<int[]> listOfItems) {
        //we need an arraylist otherwise the List items are immutable
        List<int[]> list = new ArrayList<>(listOfItems);
        int knapsackCapacity = list.getFirst()[0];
        int amountOfRowsToIterateOver = list.getFirst()[1];
        int[] indexWhereHighestValueWasFound = new int[amountOfRowsToIterateOver];
        int highestValue = 0;
        int amountOfItemsSummed = 0;
        int currentValue = 0;
        int currentWeight = 0;
        int tempValue = 0;
        int tempWeight = 0;
        list.removeFirst();
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i)[0];
            int weight = list.get(i)[1];

            if (currentWeight + weight <= knapsackCapacity) {
                currentValue += value;
                currentWeight += weight;
                amountOfItemsSummed++;
                tempValue += currentValue;

            } else if (weight <= knapsackCapacity) {
                currentValue = 0;
                currentWeight = 0;
                tempValue += value;
                tempWeight += weight;
                amountOfItemsSummed = 0;
                currentValue += tempValue;
                currentWeight += tempWeight;
                amountOfItemsSummed++;
            }
            if (tempValue > highestValue) {
                highestValue = tempValue;
                // stopped here. saving correct index (2) for testOk() is not working.
                indexWhereHighestValueWasFound = new int[amountOfItemsSummed];
                if(indexWhereHighestValueWasFound.length == 1){
                    indexWhereHighestValueWasFound[0] = i;
                } else{
                indexWhereHighestValueWasFound[i-1] = i;}
            }
            tempValue = 0;
            tempWeight = 0;

        }
        //just for testing
        System.out.println("weight: " + currentWeight + " value: " + currentValue);
        //expected result
        itemsFound = amountOfItemsSummed;
        indices = indexWhereHighestValueWasFound;
        System.out.format("found %s item(s) \n", amountOfItemsSummed);
        System.out.println(Arrays.toString(indexWhereHighestValueWasFound) + " (index where value was found)");
        return currentValue;
    }

    public int getItemsFound() {
        return itemsFound;
    }
    public int[] getIndices() {
        return indices;
    }
}
