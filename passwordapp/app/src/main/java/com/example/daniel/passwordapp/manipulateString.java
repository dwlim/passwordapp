package com.example.daniel.passwordapp;

import java.util.ArrayList;

public class manipulateString {

    // merges 3 strings into 1
    // random order + letter count
    public String mergeStrings(String a, String b, String c){
        String result = "";
        ArrayList<String> parts = new ArrayList<String>();

        int number = 0;
        parts.add(a);
        parts.add(b);
        parts.add(c);

        for(int i=0; i<parts.size(); i++){
            number += parts.get(i).length();
        }
        String temp = number + "";
        parts.add(temp);

        while(parts.size()!=0){
            int rand = (int) (Math.random() * parts.size());
            result += parts.get(rand);
            parts.remove(rand);
        }

        return result;
    }

    public String replaceCapital(String a, int n){
        String result = a;

        ArrayList<Integer> index = new ArrayList<Integer>();
        for(int i=0; i<result.length(); i++){
            char z = result.charAt(i);
            if(z>96 && z<123){
                index.add(i);
            }
        }

        ArrayList<Integer> change = new ArrayList<Integer>();
        if(index.size() > n){
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(count < n) {
                    int rand = (int) (Math.random() * index.size());
                    if (rand + 1 < index.size()) {
                        if (index.get(rand) + 1 == index.get(rand + 1)) {
                            change.add(index.get(rand));
                            count ++;
                            if(count < n) {
                                change.add(index.get(rand + 1));
                                index.remove(rand + 1);
                                count++;
                            }
                            index.remove(rand);
                        }
                    }
                    else {
                        change.add(index.get(rand));
                        index.remove(rand);
                        count++;
                    }
                }

            }
        }
        else{
            change = index;
        }

        for(int i=0; i<change.size(); i++){
            int x = change.get(i);
            result = result.substring(0,x) + Character.toUpperCase(result.charAt(x)) + result.substring(x+1);
        }
        return result;
    }

    public String replaceSpecialChar(String a, int n){
        String result = a;
        ArrayList<Integer> index = new ArrayList<Integer>();
        for(int i=0; i<result.length(); i++){
            char z = result.charAt(i);
            if(z=='a' || z=='e' || z=='i' || z=='o' || z=='u' || z=='y'){
                index.add(i);
            }
        }
        ArrayList<Integer> change = new ArrayList<Integer>();
        if(index.size() > n){
            for(int i=0; i<n; i++){
                int rand = (int)(Math.random() * index.size());
                change.add(index.get(rand));
                index.remove(rand);
            }
        }
        else{
            change = index;
        }
        for(int i=0; i<change.size(); i++){
            switch(result.charAt(change.get(i))){
                case 'a':
                    result = result.substring(0,change.get(i)) + '@' + result.substring(change.get(i) +1);
                    break;
                case 'e':
                    result = result.substring(0,change.get(i)) + '#' + result.substring(change.get(i) +1);
                    break;
                case 'i':
                    result = result.substring(0,change.get(i)) + '!' + result.substring(change.get(i) +1);
                    break;
                case 'o':
                    result = result.substring(0,change.get(i)) + '*' + result.substring(change.get(i) +1);
                    break;
                case 'u':
                    result = result.substring(0,change.get(i)) + '^' + result.substring(change.get(i) +1);
                    break;
                case 'y':
                    result = result.substring(0,change.get(i)) + '?' + result.substring(change.get(i) +1);
                    break;
            }
        }
        System.out.println(result);
        return result;
    }

}
