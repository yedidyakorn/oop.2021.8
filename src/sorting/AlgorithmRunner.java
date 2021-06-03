package sorting;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

// TODO: Add dependency injection and annotations to this file
public class AlgorithmRunner {
    @Inject
    private @Named("qued")
    SortingAlgorithm<Integer> quadraticAlgorithm;
    @Inject
    private @Named("nlogn")
    SortingAlgorithm<Integer> nlognAlgorithm;
    @Inject
    private @Size
    int numberOfElements;


    public void runAlgorithms() {
        Random rand = new Random();
        Integer[] ints = rand.ints(1, Integer.MAX_VALUE)
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
