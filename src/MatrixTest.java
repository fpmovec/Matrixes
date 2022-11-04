import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void matrixPermutationTestOne() {
        Integer[][] testMatrix =
                {
                        {3, 4, 5, 6},
                        {11, 5, 1, 7},
                        {12, 77, 16, 9},
                        {55, 33, 23, 17}
                };
        Matrix.MatrixInformation info = new Matrix.MatrixInformation();
        info.matrix = testMatrix;
        info.mSize = 4;
        info.nSize = 4;
        info.minimal = 1;
        info.minimalI = 1;
        info.minimalJ = 2;
        Integer[][] expectedMatrix = {
                {3, 4, 6, 5},
                {12, 77, 9, 16},
                {55, 33,17, 23},
                {11, 5, 7, 1}
        };
        Integer[][] actualMatrix = Matrix.MatrixPermutation(info, info.minimal);
          Assert.assertEquals(expectedMatrix, actualMatrix);
    }
    @Test
    public void matrixPermutationTestTwo() {
        Integer[][] testMatrix =
                {
                        {3, 4, 5, 6},
                        {11, 5, 1, 7},
                        {12, 77, 16, 9},
                        {55, 33, 23, 17}
                };
        Matrix.MatrixInformation info = new Matrix.MatrixInformation();
        info.matrix = testMatrix;
        info.mSize = 4;
        info.nSize = 4;
        info.minimal = 1;
        info.minimalI = 1;
        info.minimalJ = 2;
        Integer[][] expectedMatrix = {
                {3, 4, 6, 5},
                {12, 77, 9, 16},
                {55, 33,17, 23},
                {11, 5, 1, 7}
        };
        Integer[][] actualMatrix = Matrix.MatrixPermutation(info, info.minimal);

        Assert.assertFalse(java.util.Arrays.equals(expectedMatrix, actualMatrix));
    }
}