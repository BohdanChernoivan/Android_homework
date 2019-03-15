package com.example.dz_13;

import java.util.LinkedList;

public class ArrayPicture {

    private LinkedList arrayList = new LinkedList();
    private static int num = 0;

    ArrayPicture(int[] pg) {
        for (int x : pg) {
            arrayList.add(x);
        }
    }

    public int getNextPicture() {
        setNext();
        return arrayList.get(num).hashCode();
    }

    private void setNext() {
        num++;
        if (num > arrayList.size() - 1) {
            num = 0;
        }
    }

    private void setPrevious() {
        num--;
        if (num < 0) {
            num = arrayList.size() - 1;
        }
    }

    public int getPreviousPicture() {
        setPrevious();
        return arrayList.get(num).hashCode();
    }

    public int getNum() {
        return num;
    }

    public LinkedList getArrayList() {
        return arrayList;
    }

    public void setArrayList(LinkedList arrayList) {
        this.arrayList = arrayList;
    }
}
