public class Main {
    public static void main(String[] args) {
        KWArrayList<Integer> myList = new KWArrayList<>();
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(34);
        myList.add(0);
        myList.add(10);
        

        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }
        System.out.println(myList.lastIndexOf(10));
        System.out.println(myList.contains(2));
    }
}
