package week06.BankAccount;

/**
 * Created by georgipavlov on 08.01.16.
 */
public class BankAccount {
    private String firstName;
    private String lastName;
    private int age;
    private double balance;
    private double  interest;
    private int type;
    private boolean canW;
    private static long count = 0;
    private String[] operations;
    private int coutOperation;


    public BankAccount(String firstName, String lastName, int age,
                       double balance, double interest, int type) throws BankExeption {

        validateName(firstName);
        validateName(lastName);
        validateAge(age);
        validateBanance(balance);
        validateInterest(interest);
        validateType(type);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.balance = balance;
        this.interest = interest;
        this.type = type;
        count++;
        operations = new String[5];
    }

    public int getCoutOperation() {
        return coutOperation;
    }


    private void validateName(String str) throws BankExeption {
        for (int i = 1; i <str.length() ; i++) {
            char a= str.charAt(i);
            if(Character.isLetter(a)){
                if(Character.isLowerCase(a)){
                    continue ;
                }
            }
            throw new BankExeption(" name problem");
        }
        if(!Character.isUpperCase(str.charAt(0))){
            throw new BankExeption(" name problem");
        }
    }


    private void validateAge(int age) throws BankExeption {
        if(age <18 || age > 100){
            throw new BankExeption("age problem");
        }
    }

    private void validateInterest(double interest) throws BankExeption {
        if(interest <0){
            throw  new BankExeption("invalid interest");
        }
        if(interest > 1){
            canW = false;
        }
    }

    private void validateType(int type) throws BankExeption {
        if(!(type == 1 || type == 0)){
            throw new BankExeption("type problem");
        }
    }

    private void validateBanance(double balance) throws BankExeption {
        if(balance < 0){
            throw new BankExeption("balance problem");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterest() {
        return interest;
    }

    public int getType() {
        return type;
    }

    public boolean isCanW() {
        return canW;
    }

    public long getCount1() {
        return count;
    }

    public String[] getOperations() {
        return operations;
    }
}
