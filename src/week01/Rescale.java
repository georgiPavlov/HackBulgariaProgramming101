package week01;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Rescale {
    int[][] rescale(int[][] original, int newWidth, int newHeight) {
        boolean small =false;
        if(original.length > newHeight && original[0].length > newWidth){
            small=true;
        }
        int[][] newImage = new int[newHeight][newWidth];
        int count = 0;
        int sum = 0;
        int x = 0, y = 0;
        if(small) {
            int x_radio = original.length / newWidth;
            int y_radio = original[0].length / newHeight;
            int[][] temp = new int[original[0].length][newWidth];

            for (int i = 0; i < original[0].length; i++) {
                for (int j = 0; j < original.length; j++) {
                    sum += original[i][j];
                    if (count == x_radio) {
                        temp[y][x] = sum / count;
                        x++;
                        count = 0;
                        sum = 0;
                    }
                    count++;
                }
                y++;
            }

            count = 0;
            sum = 0;
            x = 0;
            y = 0;

            BigInteger big = BigInteger.valueOf(sum);
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    if(big.add(BigInteger.valueOf(temp[i][j])).compareTo
                            (BigInteger.valueOf(Integer.MAX_VALUE)) == 1){
                        System.out.println("to big sum err Integer");
                        int[][] err = new int[0][0];
                        return err;
                    }
                    sum += temp[i][j];
                    if (count == y_radio) {
                        newImage[y][x] = sum / count;
                        y++;
                        count = 0;
                        sum = 0;
                    }
                    count++;
                }
                x++;
            }
        }else {
            int x_radio = newWidth /original.length ;
            int y_radio = newHeight /original[0].length ;
            int[][] temp2 = new int[original[0].length][newWidth];

            for (int i = 0; i < original[0].length; i++ , y++) {
                for (int j = 0; j < original.length; j++ ,x++) {
                    temp2[y][x]= original[i][j];
                    if (count == x_radio) {
                        for (int k = 0; k < count; k++) {
                            temp2[y][x] = 0;
                            x++;
                        }
                        count = 0;
                    }
                }
            }

            count = 0;
            x = 0;
            y = 0;


            for (int i = 0; i < temp2.length; i++,x++) {
                for (int j = 0; j < temp2[0].length; j++ , y++) {
                    newImage[y][x]= temp2[i][j];
                    if (count == y_radio) {
                        for (int k = 0; k < count; k++) {
                            newImage[y][x] = 0;
                            y++;
                        }
                        count = 0;
                        sum = 0;
                    }
                    count++;
                }
                x++;

            }
        }

        return newImage;
    }
}
