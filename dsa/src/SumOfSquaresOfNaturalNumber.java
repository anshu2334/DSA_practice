public class SumOfSquaresOfNaturalNumber {
    public static int sumOfSquareOfNaturals(int n){
        return (n * (n+1)* ((2*n)+1))/6;
    }

    public static void main(String[] args) {
        System.out.println(sumOfSquareOfNaturals(3));
    }
}
