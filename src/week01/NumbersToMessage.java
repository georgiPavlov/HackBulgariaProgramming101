package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class NumbersToMessage {
    private int[] pressedSequence;
    private StringBuilder b = new StringBuilder();
    private boolean upperLetter = false;

    public String numbersToMessage(int[] pressedSequence1) {
        pressedSequence = pressedSequence1;
        p:
        for (int i = 0; i < pressedSequence.length; i++) {
            if (pressedSequence[i] == 1) {
                upperLetter = true;
            }
            if (pressedSequence[i] == 0) {
                b.append(" ");
                continue p;
            } else {
                switch (pressedSequence[i]) {
                    case 2:
                        i = Letter(i, 'a', 'b', 'c', ' ');
                        continue p;
                    case 3:
                        i = Letter(i, 'd', 'e', 'f', ' ');
                        continue p;
                    case 4:
                        i = Letter(i, 'g', 'h', 'i', ' ');
                        continue p;
                    case 5:
                        i = Letter(i, 'j', 'k', 'l', ' ');
                        continue p;
                    case 6:
                        i = Letter(i, 'm', 'n', 'o', ' ');
                        continue p;
                    case 7:
                        i = Letter(i, 'p', 'q', 'r', 's');
                        continue p;
                    case 8:
                        i = Letter(i, 't', 'u', 'v', ' ');
                        continue p;
                    case 9:
                        i = Letter(i, 'w', 'x', 'y', 'z');
                        continue p;
                }
            }
        }
        return b.toString();
    }

    private int Letter(int i, char x, char y, char z, char w) {
        int temp = i;
        int count = 0;
        while (pressedSequence[i] == pressedSequence[temp] && pressedSequence[i] != -1) {
            count++;
            temp++;
            if (pressedSequence.length - 1 <= temp) {
                break;
            }
        }
        if (w == ' ' && count > 3) {
            count = 3;
            temp = i + 2;
        } else if (w != ' ' && count > 4) {
            count = 4;
            temp = i + 3;
        } else {
            temp = count - 1 + i;
        }
        if (count == 1) {
            if (upperLetter) {
                b.append(Character.toUpperCase(x));
                upperLetter = false;
            } else {
                b.append(x);
            }
        } else if (count == 2) {
            if (upperLetter) {
                b.append(Character.toUpperCase(y));
                upperLetter = false;
            } else {
                b.append(y);
            }
        } else if (count == 3) {
            if (upperLetter) {
                b.append(Character.toUpperCase(z));
                upperLetter = false;
            } else {
                b.append(z);
            }
        } else {
            if (upperLetter) {
                b.append(Character.toUpperCase(w));
                upperLetter = false;
            } else {
                b.append(w);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        NumbersToMessage numbersToMessage = new NumbersToMessage();
        System.out.println(numbersToMessage.numbersToMessage(new int[]{1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 2, 6, 6, 3, 2}));
    }
}
