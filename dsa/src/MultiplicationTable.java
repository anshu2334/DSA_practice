public class MultiplicationTable {
    public static void printMultiplicationTable(int number){
        for(int i=0; i< 10;i++){
            System.out.println(number +" * "+(i+1) +" = "+number*(i+1));
        }
    }

    public static void main(String[] args) {
        printMultiplicationTable(5);
    }
}
