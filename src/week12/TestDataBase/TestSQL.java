package week12.TestDataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by georgipavlov on 19.02.16.
 */
public class TestSQL {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/OUR_TEST_UNITS";

    static final String USER = "root";
    static final String PASS = "azsamgeorgi1321";
    static final int maxCount = 3;

    public void makeTest(){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");


            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            System.out.println("enter your name..");
            Scanner scanner = new Scanner(System.in);
            String name =scanner.nextLine();
              //--------------------------------------------------------
            String sql1 = "SELECT * FROM TESTS_IN ORDER BY RAND() LIMIT 3";
            ResultSet rs = stmt.executeQuery(sql1);
            //STEP 5: Extract data from result set

            int trueCount=0;
            int falseCount=0;
            while(rs.next()){
                //Retrieve by column name
                String question  = rs.getString("question");
                ArrayList<String> questions = new ArrayList<>();
                String correct_answer  = rs.getString("correct_answer");
                questions.add(rs.getString("incorrect_answer_1"));
                questions.add(rs.getString("incorrect_answer_2"));
                questions.add(rs.getString("incorrect_answer_3"));
                questions.add(rs.getString("correct_answer"));
                Collections.shuffle(questions);
                System.out.println(question);
                for (int i = 0; i < questions.size();i++) {
                    System.out.println(i + " " + questions.get(i));
                }

                System.out.println("Enter your choose...");
                int answer = scanner.nextInt();
                if(questions.get(answer).equals(correct_answer)){
                    trueCount++;
                }else {
                    falseCount++;
                }

            }
            rs.close();
             //----------------------------------------------------------

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
            double getMark =( maxCount / trueCount)*100;
            getMark = getMarkUser((int)getMark);


            String sql2 = "INSERT INTO SCOREBOARD " +
                    "VALUES (NULL,'"+name+"','"+trueCount+"','"+falseCount+"','"+(int)getMark+"')";
            stmt.executeUpdate(sql2);
            System.out.println("Inserted records into the table...");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main


    public int getMarkUser(int count){
        int mark = 2;
        if(count > 50 && count < 60 ){
            mark =3;
        }else if(count > 60 && count < 70 ){
            mark = 4;
        }else if(count >= 70 && count < 80){
            mark =5;
        }else if(count >= 80 ){
            mark =6;
        }
        return mark;
    }


    public static void main(String[] args) {
        TestSQL testSQL = new TestSQL();
        testSQL.makeTest();
    }



}//end JDBCExample



