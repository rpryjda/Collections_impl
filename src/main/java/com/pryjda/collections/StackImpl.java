package com.pryjda.collections;

import lombok.Getter;
import lombok.Setter;

public class StackImpl<T> implements Stack<T> {

    private Item head;

    public void push(T data) {
        Item newItem = new Item();
        newItem.setData(data);
        newItem.setIndicator(head);
        head = newItem;
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        Item oldHead = head;
        head = head.getIndicator();
        return oldHead.getData();
    }

    public T peek() {
        if(head == null){
            return null;
        }
        return head.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Getter
    @Setter
    private class Item {
        private T data;
        private Item indicator;
    }

    @Override
    public String toString() {
        return printAllData();
    }

    private String printAllData() {
        String printedText = "";
        Item printIndicator = head;

        while (printIndicator != null) {
            printedText += printIndicator.getData().toString() + ", ";
            printIndicator = printIndicator.getIndicator();
        }

        if (printedText.endsWith(", ")) {
            printedText = printedText.substring(0, printedText.length() - 2);
        }

        return "[" + printedText + "]";
    }
}
