package sorting;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

// TODO: Add java classes (in separate files for annotations and aspects)
public class MainApp {
    static WeldContainer container = new Weld().initialize();

    public static void main(String[] args) {
        AlgorithmRunner algorithm = container.instance().select(AlgorithmRunner.class).get();
        algorithm.runAlgorithms();
    }

    @Produces
    public @Named("nlogn")
    SortingAlgorithm<Integer> NLogN() {
        return container.instance().select(QuickSort.class).get();
    }

    @Produces
    public @Named("qued")
    SortingAlgorithm<Integer> Qued() {
        return container.instance().select(BubbleSort.class).get();
    }

    @Produces
    public @Size
    int numberOfElements() {
        return 100000;
    }
}
