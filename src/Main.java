package com.javarush.task.task27.task2711;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calc(br.readLine()));
    }
    public static String calc(String input) throws Exception {
        ArrayList<String> strings =new ArrayList<>();
        Collections.addAll(strings, input.split("\\s"));
        if (strings.size()!=3 || strings.get(1).length()>1) throw new Exception("");//the second condition  isn't necessary

        int a,b, result;
        boolean greec=false;
        ArrayList<String> greekDigits =new ArrayList<>();
        greekDigits.add(0, "-");
        greekDigits.add(1, "I");
        greekDigits.add(2, "II");
        greekDigits.add(3, "III");
        greekDigits.add(4, "IV");
        greekDigits.add(5, "V");
        greekDigits.add(6, "VI");
        greekDigits.add(7, "VII");
        greekDigits.add(8, "VIII");
        greekDigits.add(9, "IX");
        greekDigits.add(10, "X");
        greekDigits.add(11, "XI");
        greekDigits.add(12, "XII");
        greekDigits.add(13, "XIII");
        greekDigits.add(14, "XIV");
        greekDigits.add(15, "XV");
        greekDigits.add(16, "XVI");
        greekDigits.add(17, "XVII");
        greekDigits.add(18, "XVII");
        greekDigits.add(19, "XIX");
        greekDigits.add(20, "XX");

        try {
            a=Integer.parseInt(strings.get(0));
        }catch (NumberFormatException ignored){
            a=-1;
        }
        try {
            b=Integer.parseInt(strings.get(2));
        }catch (NumberFormatException ignored){
            b=-1;
        }
        if ((a==-1 && b!= -1) || (a!=-1 && b==-1)){
            throw new Exception("");
        }

        // parsing Greek digits
        if (a==-1){
            greec=true;
            a=greekDigits.indexOf(strings.get(0));
            b=greekDigits.indexOf(strings.get(2));
            if (a==-1 || b==-1) throw new Exception("");
        }


        if ((a<1 || a>10) || (b<1 || b>10)){ throw new Exception(""); }
        switch (strings.get(1)){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
            default: throw new Exception("");
        }

        if (greec) {
            if (result<1) throw new Exception("");
            return greekDigits.get(result);
        }
        return Integer.toString(result);
    }
}
