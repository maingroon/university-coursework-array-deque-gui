package com.sumdu.service;

import com.sumdu.util.ErrorUtil;

import java.io.IOException;
import java.util.ArrayDeque;

public class ArrayDequeService {

    private final ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    public boolean add(String element, boolean isFirstPosition) throws IOException {
        if (element == null || element.isEmpty()) {
            ErrorUtil.showError("Please enter value.");
            return false;
        }

        try {
            int value = Integer.parseInt(element);

            if (value < -99999 || value > 99999) {
                ErrorUtil.showError("Please enter value in bounds\n -99999 <= n <= 99999");
                return false;
            }

            if (isFirstPosition) {
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
            return true;
        } catch (NumberFormatException e) {
            ErrorUtil.showError("Please enter only integer value");
            return false;
        }
    }

    public Integer poll(boolean isFirstPosition) throws IOException {
        if (arrayDeque.isEmpty()) {
            ErrorUtil.showError("Cannot poll element\nfrom empty ArrayDeque");
            return null;
        }

        if (isFirstPosition) {
            return arrayDeque.removeFirst();
        } else {
            return arrayDeque.removeLast();
        }
    }

    public Integer peek(boolean isFirstPosition) throws IOException {
        if (arrayDeque.isEmpty()) {
            ErrorUtil.showError("Cannot peek element\nfrom empty ArrayDeque");
            return null;
        }

        if (isFirstPosition) {
            return arrayDeque.peekFirst();
        } else {
            return arrayDeque.peekLast();
        }
    }

    public boolean remove(boolean isFirstPosition) throws IOException {
        if (arrayDeque.isEmpty()) {
            ErrorUtil.showError("Cannot remove element\nfrom empty ArrayDeque");
            return false;
        }

        if (isFirstPosition) {
            arrayDeque.removeFirst();
        } else {
            arrayDeque.removeLast();
        }
        return true;
    }

    public int getSize() {
        return arrayDeque.size();
    }

    public void clear() {
        arrayDeque.clear();
    }
}
