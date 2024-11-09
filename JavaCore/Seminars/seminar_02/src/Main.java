public class Main {
    public static void main(String[] args) {
//        CrossArray crossArray = new CrossArray(-7);
//        crossArray.print();

//        MyArray myArray = new MyArray(new int[]{1,2,4,5,6});
//        myArray.print();
//        myArray.add(19);
//        myArray.print();
//        myArray.add(0, 20);
//        myArray.print();
//        myArray.add(4, 111);
//        myArray.print();

        PigeonSort pigeonSort = new PigeonSort(new int[]{1,9,3,6,2,65,6,7,45,5,6,7,2,1});
        pigeonSort.sort();
        pigeonSort.print();
    }
}