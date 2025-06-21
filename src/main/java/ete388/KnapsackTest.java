package se.general.projects;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class KnapsackTest {

    @Test
    public void testOk(){

        int [] i1 =  {5,3};
        int [] i2 =  {1,5};
        int [] i3 =  {10,5};
        int [] i4 =  {100,5};

        Knapsack k = new Knapsack();
       int actualValue = k.calculateValue(List.of(i1, i2, i3, i4));
       int itemsFound = k.getItemsFound();
       String indices = k.getIndices();
       assertThat(actualValue, is(100));
       assertThat(itemsFound, is(1));
       assertThat(indices, is("2 "));
    }
    @Test
    public void testOk1(){
        //this lamost works. the first two indices are incorrect. now shows [0,0,3] should be [1,2,3]
        int [] i1 =  {6,4};
        int [] i2 =  {5,4};
        int [] i3 =  {4,3};
        int [] i4 =  {3,2};
        int [] i5 =  {2,1};

        Knapsack k = new Knapsack();
        int actualValue =  k.calculateValue(List.of(i1,i2,i3,i4,i5));
        assertThat(actualValue, is(9));
        int itemsFound = k.getItemsFound();
        String indices = k.getIndices();
        assertThat(itemsFound, is(3));
        assertThat(indices, is("1 2 3 "));


    }
    @Test
    public void testOk2(){
//this almost works as well but it needs to find indices. should be [0,1,3]
        int [] i1 =  {5,3};
        int [] i2 =  {1,1};
        int [] i3 =  {10,1};
        int [] i4 =  {100,10};
        int [] i5 =  {100,1};

        Knapsack k = new Knapsack();
        int actualValue = k.calculateValue(List.of(i1,i2,i3,i4,i5));
        assertThat(actualValue, is(111));
        int itemsFound = k.getItemsFound();
        String indices = k.getIndices();
        assertThat(itemsFound, is(3));
        assertThat(indices, is("0 1 3 "));


    }
}
