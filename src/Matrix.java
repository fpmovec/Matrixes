
import com.bluecatcode.junit.shaded.org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Scanner;
import java.util.Comparator;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.*;
import java.lang.*;

public class Matrix {
    static Scanner inputScanner = new Scanner(System.in);
   // static Locale locFR = new Locale("en");
    static NumberFormat format = NumberFormat.getCurrencyInstance();
    public static void main(String[] args) {
        //Integer[][] arr = new Integer[5][3];


        Random rand = new Random();

        System.out.println("Enter matrix size(n * m)");
        MatrixInformation _matrix = new MatrixInformation();
        _matrix.nSize = inputScanner.nextInt();
        System.out.printf("n = %d\n", _matrix.nSize);
        _matrix.mSize = inputScanner.nextInt();
        System.out.printf("m = %d\n", _matrix.mSize);
        _matrix.matrix = new Integer[_matrix.nSize][_matrix.mSize];
       for (int i = 0; i < _matrix.nSize; i++){
        for(int j = 0; j < _matrix.mSize; j++){
        _matrix.matrix[i][j] = rand.nextInt(100) + rand.nextInt(10) + 2;
         }
       }
      _matrix.minimal = _matrix.matrix[0][0];

       for (int i = 0; i < _matrix.nSize; i++){
           for (int j = 0; j < _matrix.mSize; j++){
               if (_matrix.matrix[i][j] < _matrix.minimal){
                   _matrix.minimal = _matrix.matrix[i][j];
                   _matrix.minimalI = i;
                   _matrix.minimalJ = j;
               }
           }
       }
        for (int i = 0; i < _matrix.nSize; i++){
            for(int j = 0; j < _matrix.mSize; j++){
                System.out.print(_matrix.matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print(_matrix.minimal + "\n");
       _matrix.matrix = MatrixPermutation(_matrix, _matrix.minimal);
        MemberComparator comparer = new MemberComparator();
        Arrays.sort(_matrix.matrix[0], 0, _matrix.mSize, comparer);

        for (int i = 0; i < _matrix.nSize; i++){
            for(int j = 0; j < _matrix.mSize; j++){
                if (i == _matrix.nSize - 2 || i == _matrix.nSize - 1) System.out.print(format.format(_matrix.matrix[i][j]) + " ");
                else System.out.print(_matrix.matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("Enter a searching element: ");
        Integer search = inputScanner.nextInt();
        // int pos = Search(fMatrix.matrix[0], search);
        int pos = Arrays.binarySearch(_matrix.matrix[0], 0, _matrix.mSize, search, comparer);
        System.out.printf("Position of searchingElement is %d", pos + 1);


    }


    public static Integer[][] MatrixPermutation(MatrixInformation fMatrix, Integer min) {
        Integer[] temp;
        for (int i = fMatrix.minimalI; i < fMatrix.nSize - 1; i++){
        temp = fMatrix.matrix[i];
        fMatrix.matrix[i] = fMatrix.matrix[i + 1];
        fMatrix.matrix[i + 1] = temp;
       }
        int _temp;
       for (int i = 0; i < fMatrix.nSize; i++){
           for (int j = fMatrix.minimalJ; j < fMatrix.mSize - 1; j++){
              _temp = fMatrix.matrix[i][j];
               fMatrix.matrix[i][j] = fMatrix.matrix[i][j + 1];
               fMatrix.matrix[i][j + 1] = _temp;
           }
       }
       return fMatrix.matrix;

    }

public static class MemberComparator implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            if (a.equals(b)) return 0;
           else if (a > b) return -1;
           else return 1;
        }


}

    public static class MatrixInformation{
        public  MatrixInformation(){
            matrix = null;
            nSize = 0;
            mSize = 0;
            minimal = 0;
            minimalI = 0;
            minimalJ = 0;
        }

        @Override
        public boolean equals(Object obj){
            boolean isEqual = true;
           if (this == obj) return true;
           for (int i = 0; i < ((MatrixInformation)obj).nSize; i++){
               for (int j = 0; j < ((MatrixInformation)obj).mSize; j++){
                   isEqual = ((MatrixInformation) obj).matrix[i][j] == this.matrix[i][j];
               }
           }
            return isEqual;
        }

     public Integer[][] matrix;
     public Integer nSize;
     public Integer mSize;
     public Integer minimal;
     public Integer minimalI;
     public Integer minimalJ;
    }
}

