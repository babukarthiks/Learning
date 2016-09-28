package com.learning.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {

    public static void main(String[] args) {

        List<String> strings = new ArrayList();
        strings.add("Karthik");
        strings.add("babu");

        Iterator<String> i = strings.iterator();
        while (i.hasNext()) {
            i.next();
            i.remove();
        }

        for (String s : strings) {
            System.out.println(s);
        }
    }

}
