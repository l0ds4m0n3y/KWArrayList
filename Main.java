
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // KWArrayList<Integer> myList = new KWArrayList<>();
        // myList.add(7);
        // myList.add(8);
        // myList.add(9);
        // myList.add(34);
        // myList.add(0);
        // myList.add(10);

        // myList.add(6, 69);
        // myList.remove(myList.get(3));
        // for(int i = 0; i < myList.size(); i++){
        //     System.out.println(myList.get(i));
        // }
        // System.out.println();
        // System.out.println(myList.lastIndexOf(10));
        // System.out.println(myList.contains(0));
        // System.out.println(myList.indexOf(34));
        // System.out.println(myList.lastIndexOf(34));

        KWArrayList<String> myList = new KWArrayList<>();
        myList.add("cody");
        myList.add("emma");
        myList.add("parker");
        myList.add("cody");


        //myList.remove("david");
        //myList.set(myList.size(), "amira");
        myList.add(1, "peter");
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }
        System.out.println(myList.contains("parker"));
        System.out.println(myList.indexOf("cody"));
        
        // ArrayList<Integer> arrayList = new ArrayList<>(4);
        // arrayList.add(7);
        // arrayList.add(8);
        // arrayList.add(9);
        // arrayList.add(34);
        // arrayList.add(0);
        // arrayList.add(10);

        // arrayList.add(arrayList.size(), 69);

        // for(int i : arrayList){
        //     System.out.println(i);
        // }
    }
}
