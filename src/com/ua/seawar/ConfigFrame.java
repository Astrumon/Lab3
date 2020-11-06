package com.ua.seawar;

public interface ConfigFrame {
    default public int getI(char y) {
        int iLet = 0;
        switch (y) {
            case 'A':
                iLet = 1;
                break;
            case 'B':
                iLet = 2;
                break;
            case 'C':
                iLet = 3;
                break;
            case 'D':
                iLet = 4;
                break;
            case 'E':
                iLet = 5;
                break;
            case 'F':
                iLet = 6;
                break;
            case 'G':
                iLet = 7;
                break;
            case 'H':
                iLet = 8;
                break;
            case 'I':
                iLet = 9;
                break;
            case 'J':
                iLet = 10;
                break;
        }
        return iLet;
    }
    default public boolean isBorder(int x, int y) {
        return (x > 0 && y > 0) && (x < 11 && y < 11);
    }
}
