package week02.TheOne;

/**
 * Created by georgipavlov on 29.11.15.
 */
public class Matrix implements MatrixOperation{
    private Pixel[][] pixels;

    public Matrix(Pixel[][] pixels){
        this.pixels=pixels;
    }


    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        return matrix[y][x];
    }

    @Override
    public Pixel[][] brightnessReduce(Pixel[][] matrix) {
       Pixel[][] result=null;
        Pixel pixel ;
        float brightenFactor = 1.2f;
        int r;
        int g;
        int b;
        for (int i = 0; i <matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = new Pixel();
                pixel = withPixel(i,j,matrix);
                r=(int)(pixel.getR()*brightenFactor);
                g=(int)(pixel.getG()*brightenFactor);
                b=(int)(pixel.getB()*brightenFactor);
                result[i][j].setR(r);
                result[i][j].setG(g);
                result[i][j].setB(b);
            }
        }
        return result;


    }

    @Override
    public Pixel grayscale(int x, int y, Pixel[][] matrix) {
        Pixel t = matrix[y][x];
        int red= t.getR();
        int green = t.getG();
        int blue = t.getB();
        int temp = (red+green+blue)/3;
        t.setR(temp);
        t.setG(temp);
        t.setB(temp);
        matrix[y][x] = t;

        return t;
    }

    String operate(){
        Pixel pixel;
        StringBuilder b = new StringBuilder();
        for (int y = 0; y <pixels[0].length ; y++) {
            for (int x = 0; x <pixels.length ; x++) {
                pixel=withPixel(x,y,pixels);
                b.append(pixel.getR());
                b.append(" ");
                b.append(pixel.getG());
                b.append(" ");
                b.append(pixel.getB());
                b.append(" ");
            }
            b.append("\n");
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return operate();
    }
}
