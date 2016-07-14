package com.javalearn.test.level25.lesson02.task01;

/* Новые возможности!
Используя возможности enum-а реализуйте метод getLetterPosition, который должен возвращать позицию буквы (A - 1).
Не должно быть закоментированного кода.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Alphabet.G.getLetterPosition());
    }

    public enum Alphabet {
        A, B, C, D, E,
        F, G, H, I, J,
        K, L, M, N, O,
        P, Q, R, S, T,
        U, V, W, X, Y, Z;

        int getLetterPosition() {
            for (int i=0;i<Alphabet.values().length;i++)
                if (this.ordinal()==i)
                    return i+1;
            return -1;
        }
    }
}
