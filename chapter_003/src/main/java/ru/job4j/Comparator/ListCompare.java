package ru.job4j.Comparator;

import java.util.Comparator;

/**
 * 3. Компаратор для строк. [#35008]
 * Очень часто возникает ситуация, когда нужно сравнить два слова.

 У нас есть готовый метод String.compareTo.

 В это задании нужно создать подобный метод самому.

 Вам нужно реализовать компаратор для сравнения двух массивов символов.

 Необходимо реализовать поэлементное сравнение двух списков, т.е. сравниваем элементы двух списков, находящихся
 на одних и тех же позициях (по одним и тем же индексом). Сравнение в лексикографическом порядке.

 В этом задании нельзя использовать метод String.compateTo.

 Вы можете использовать

 String.charAt(int index)

 Integer.compare(int left, int right),

 Character.compare(char left, char right);
 */

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            if (Character.compare(left.charAt(i), right.charAt(i)) != 0) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        if (result == 0 && Integer.compare(left.length(), right.length()) != 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
