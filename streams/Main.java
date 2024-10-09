package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // create a stream 
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Ahmed","Ibrahim","Ali"));
        Stream<String> listStream = list.stream();
        listStream.filter((String x) -> x.startsWith("A")).forEach(System.out::println);
        System.out.println("************************");
        Stream<String> sortedList = list.stream();
        sortedList.sorted((s1,s2) -> s2.compareTo(s1)).forEach(System.out::println);
        // map 
        System.out.println("*****************************");
        Stream<String> mapStream = list.stream();
        String x = mapStream.max((s1,s2) -> s1.compareTo(s2)).get();
        System.out.println(x);

        //Optional<String> name = mapStream.findAny();
        // if(name.isPresent())
        // {
        //     System.out.println(name.get());
        // }

        //List<Car> cars = mapStream.map((String carname) -> new Car(carname)).collect(Collectors.toList());
        //cars.forEach(System.out::println);
    }
}
class Car {
    private String model;
    public Car(String model)
    {
        this.model = model;
    }
    @Override
    public String toString() {
        return "Car ["+this.model+"]";
    }
}