package week04;

import java.util.Vector;

/**
 * Created by georgipavlov on 12.12.15.
 */
public class MyVector {
    Vector vector;

    public MyVector(double... a) {
        for (int i = 0; i < a.length; i++) {
            vector.add(a[i]);
        }
    }

    public Vector getVector() {
        return vector;
    }

    public Double getVector(int i) {
        if (i > vector.size()) {
            System.out.println("cant do it too big value");
            return null;
        }
        return (double) vector.get(i);
    }


    public void getVector(int i, double vec) {
        if (i > vector.size()) {
            System.out.println("cant do it too big value");
            return;
        }
        vector.set(i, vec);
    }


    public int getSize() {
        return vector.size();
    }

    public double getLenght() {
        double result = 0;
        for (int i = 0; i < vector.size(); i++) {
            result += Math.pow((double) vector.get(i), 2);
        }
        return Math.sqrt(result);
    }

    public MyVector(MyVector r) {
        this.vector = r.getVector();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyVector)) return false;

        MyVector myVector = (MyVector) o;
        if (myVector.getSize() != vector.size()) return false;
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) != myVector.getVector(i)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public int hashCode() {
        return getVector() != null ? getVector().hashCode() : 0;
    }


    @Override
    public String toString() {
        return "MyVector{" +
                "vector=" + vector +
                '}';
    }


    public void addVector(Vector v) {
        if (v.size() != vector.size()) {
            System.out.println("Cant do operation");
        } else {
            for (int i = 0; i < vector.size(); i++) {
                double a = ((double) vector.get(i) + ((double) v.get(i)));
                vector.add(i, a);
            }
        }
    }


    public void substract(Vector v) {
        if (v.size() != vector.size()) {
            System.out.println("Cant do operation");
        } else {
            for (int i = 0; i < vector.size(); i++) {
                double a = ((double) vector.get(i) - ((double) v.get(i)));
                vector.add(i, a);
            }
        }
    }


    public void addVector(float by) {

        for (int i = 0; i < vector.size(); i++) {
            double a = ((double) vector.get(i) + by);
            vector.add(i, a);
        }
    }

    public void substract(float by) {

        for (int i = 0; i < vector.size(); i++) {
            double a = ((double) vector.get(i) - by);
            vector.add(i, a);
        }

    }

    public void multiply(float by){
        for (int i = 0; i < vector.size(); i++) {
            double a = ((double) vector.get(i) * by);
            vector.add(i, a);
        }
    }


    public void divide(float by){
        for (int i = 0; i < vector.size(); i++) {
            double a = ((double) vector.get(i) / by);
            vector.add(i, a);
        }
    }

    public Double dotProduct(Vector vector){
        if(vector.size() != this.vector.size()){
            System.out.println("Invalid operation");
            return null;
        }
        double result=1;
        double result2=1;
        for (int i = 0; i <vector.size() ; i++) {
           result *= (double)vector.get(i);
            result2*=(double)this.vector.get(i);
        }
        return result+result2;
    }


}
