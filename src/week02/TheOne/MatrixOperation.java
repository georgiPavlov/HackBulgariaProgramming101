package week02.TheOne;

/**
 * Created by georgipavlov on 29.11.15.
 */
public interface MatrixOperation {
    Pixel withPixel(int x, int y, Pixel[][] matrix);
    Pixel[][]  brightnessReduce(Pixel[][] matrix);
    Pixel grayscale(int x, int y, Pixel[][] matrix);
}
