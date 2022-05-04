package com.kruger.vaccineinventory.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmployeeValidator {

    public String setUsername(String firstName, String secondName, String firstSurname){
        StringBuffer usernameSb = new StringBuffer();
        usernameSb.append(firstName.charAt(0));
        usernameSb.append(secondName.charAt(0));
        usernameSb.append(firstSurname);
        return validateLetters(usernameSb.toString()).toLowerCase();
    }

    public String setFullName(String firstName, String secondName, String firstSurname, String secondSurname){
        StringBuffer fullNameSb = new StringBuffer();
        String space = " ";
        fullNameSb.append(firstName);
        fullNameSb.append(space);
        fullNameSb.append(secondName);
        fullNameSb.append(space);
        fullNameSb.append(firstSurname);
        fullNameSb.append(space);
        fullNameSb.append(secondSurname);
        return validateLetters(fullNameSb.toString());
    }

    public String validateLetters(String string){
        if (string == null || string.length() == 0){
            return null;
        }
        string = string.trim();
        string = string.replaceAll(" +", " ");
        string = string.replaceAll("\u0027+", "\u0027");
        string = string.toUpperCase();
        Pattern pattern = Pattern
        .compile("^[A-Z"
                + "\u00d1"
                + "\u00c1\u00c9\u00cd\u00d3\u00da"
                + "\u00c0\u00c8\u00cc\u00d2\u00d9"
                + "\u00c4\u00cb\u00cf\u00d6\u00dc"
                + "\u0027]"
                + "+( {1}[A-Z\u00d1\u00c1\u00c9\u00cd\u00d3\u00da"
                + "\u00c0\u00c8\u00cc\u00d2\u00d9"
                + "\u00c4\u00cb\u00cf\u00d6\u00dc\u0027]*){0,}+$");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return string;
        }
        return null;
    }

    public boolean validateEmail(String email){
        if (email == null || email.length() == 0){
            return false;
        }
        Pattern pattern = Pattern.compile("^([a-zA-Z\\d_\\.\\-])+\\@(([a-zA-Z\\d\\-])+\\.)"
		+ "++([a-zA-Z\\d]{2,4})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    public boolean validateIdentification(String identification){
        if (identification == null){
            return false;
        }
        int suma=0;
        if(identification.length()!=10 || identification.charAt(0)>50
                ||(identification.charAt(0)==48 && identification.charAt(1)==48)||
                (identification.charAt(0)==50 && identification.charAt(1)>52)){
            return false;
        }
        int a[]=new int [identification.length()/2];
        int b[]=new int [(identification.length()/2)];
        int c=0;
        int d=1;
        for (int i = 0; i < identification.length()/2; i++) {
            a[i]=Integer.parseInt(String.valueOf(identification.charAt(c)));
            c=c+2;
            if (i < (identification.length()/2)-1) {
                b[i]=Integer.parseInt(String.valueOf(identification.charAt(d)));
                d=d+2;
            }
        }

        for (int i = 0; i < a.length; i++) {
            a[i]=a[i]*2;
            if (a[i] > 9){
                a[i]=a[i]-9;
            }
            suma=suma+a[i]+b[i];
        }
        int aux=suma/10;
        int dec=(aux+1)*10;
        if ((dec - suma) == Integer.parseInt(String.valueOf(identification.charAt(identification.length()-1)))){
            return true;
        }else{
            return (suma%10==0 && identification.charAt(identification.length()-1)=='0');
        }
    }
}
