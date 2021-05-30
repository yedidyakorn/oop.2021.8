package sorting;
import java.util.Random;

// TODO: Add dependency injection and annotations to this file
public class AlgorithmRunner {
    SortingAlgorithm<Integer> quadraticAlgorithm = new BubbleSort();
    SortingAlgorithm<Integer> nlognAlgorithm = new QuickSort();
    int numberOfElements = 100000;
    public void runAlgorithms(){
        Random rand = new Random();
        Integer[] ints = rand.ints(1,Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
    }
}
