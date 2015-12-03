package week02.FastAndFurious;

/**
 * Created by georgipavlov on 25.11.15.
 */
public class Test {
    public static void main(String[] args) {
        Skoda skoda = new Skoda();
        Honda honda = new Honda();
        Volkswagen volkswagen = new Volkswagen();
        BMW bmw = new BMW();
        Audi audi = new Audi();
        boolean test = false;
        System.out.println(skoda.isEcoFriendly(test));
        System.out.println(honda.isEcoFriendly(test));
        System.out.println(volkswagen.isEcoFriendly(test));
        System.out.println(bmw.isEcoFriendly(test));
        System.out.println(audi.isEcoFriendly(test));

    }
}
