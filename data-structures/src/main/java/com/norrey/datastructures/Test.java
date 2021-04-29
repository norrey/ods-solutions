/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norrey.datastructures;

import com.norrey.datastructures.arraybased.ArrayQueue;

/**
 *
 * @author norrey.okumu
 */
public class Test {

    public static void main(String[] args) {
        ArrayQueue<Integer> a = new ArrayQueue<>();
        
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        a.add(11);
        a.add(12);
        a.add(13);
        a.add(14);
        a.add(15);

        a.print();

        System.out.println("Removed: " + a.remove());

        a.print();

        if (true) {
            return;
        }
    }

}
