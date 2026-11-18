import java.util.Arrays;

public class UjiClone {
    public static void main(String[] args) {
        int[][] myNumbers = new int[3][];
        myNumbers[0] = new int[5];
        myNumbers[1] = new int[3];
        myNumbers[2] = new int[1];

        // 1) clone() pada array luar -> shallow
        int[][] c = myNumbers.clone();
        System.out.println(c == myNumbers);          // false (array luar beda)
        System.out.println(c[0] == myNumbers[0]);    // true  (baris sama!)
        c[0][0] = 99;
        System.out.println(myNumbers[0][0]);         // 99 -> aslinya ikut berubah

        // mengganti seluruh baris pada salinan tidak memengaruhi asli
        c[1] = new int[10];
        System.out.println(myNumbers[1].length);     // tetap 3

        // 2) deep copy yang benar
        int[][] d = new int[myNumbers.length][];
        for (int i = 0; i < myNumbers.length; i++) {
            d[i] = myNumbers[i].clone();
        }
        d[0][0] = 123;
        System.out.println(myNumbers[0][0]);         // tetap 99 -> aman
        System.out.println(Arrays.deepToString(myNumbers));
        System.out.println(Arrays.deepToString(d));
    }
}