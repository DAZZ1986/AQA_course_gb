package org.amtel.lesson4;


// Палинлром это когда слово читается слева направо и справа на лево одинаково.
// 1      - это палиндром
// 22     - это палиндром
// 123321 - это палиндром



public class Functions {

    public static boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        return isPalindrome(word.substring(1, word.length() - 1));
    }



}
