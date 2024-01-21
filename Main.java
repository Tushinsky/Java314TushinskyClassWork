import java.util.Arrays;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
         * Строки
         * 1) Оставить в строке только один экземпляр
         *      каждого встречающегося символа.
         *      Результат вернуть
         */
        String string = "А роза упала на лапу Азора";
        string = string.toLowerCase();
        System.out.println(removeRepeatChar(string));

        /*
         * 2) Выяснить, какой символ в строке встречается
         *      максимально часто. Результат вернуть в виде символа.
         *      Подсказка: можно использовать двумерный массив.
         */
        string = "ABCDE This is my family";
        string = string.toLowerCase();
        char[] charArray = string.toCharArray();// преобразуем в массив
        char[] repeatCharArray = removeRepeatChar(string).toCharArray();// массив отсеянных символов
        // сравниваем два массива
        int maxCount = 0;// количество максимальных повторений символов
        char maxChar = 0;// символ, встречающийся чаще всего
        for (char repChar : repeatCharArray) {
            int count = 0;// количество повторений символа
            for (char ch : charArray) {
                if (ch == repChar) {
                    count++;// увеличиваем счётчик повторений
                }
            }
            if (maxCount < count) {
                maxCount = count;
                maxChar = repChar;
            }
        }
        System.out.println("Чаще всего встречается символ " + maxChar + " " + maxCount + " раз");

        /*
         3) Из двух строк сформировать одну- любым удобным способом
         *      (без использования множеств), в которой будут только уникальные
         *      (не встречающиеся в другой строке) слова.
         *      Результат - строка
         */
        String string1 = "Из двух строк сформировать одну любым удобным способом";
        String string2 = "без использования сформировать одну множеств в которой будут только уникальные";
        // преобразуем строки в массивы
        String[] split1 = string1.split(" ");
        String[] split2 = string2.split(" ");

        StringBuilder builder = new StringBuilder();// сюда будем собирать строку
        for (String split: split1) {
            boolean find = false;// флаг совпадений
            for (String sp : split2) {
//                System.out.println(sp + " " + split);
                if (Objects.equals(sp, split)) {
                    find = true;// если строки совпадают, устававливаем флаг
                    break;// выходим из цикла
                }
            }
            // проверяем состояние флага
            if (!find) {
                // если совпадений не найдено, добавляем в строку
                builder.append(split).append(" ");
            }
        }
        // вывод результирующей строки
        System.out.println("result : " + builder);

        /*
         * 4) Даны две строки. Сложить их в одну так, чтобы все слова шли
         *      в алфавитном порядке (с учетом только первой буквы)
         *      Результат - строка
         */
        // используем строки и их массивы из предыдущего задания
        // здесь все слова и первые буквы слов
        String stringArray = "Из двух строк сформировать одну любым удобным способом".
                concat(" ").
                concat("без использования множеств в которой будут только уникальные");
        String[] stringArray1 = stringArray.split(" ");// слов строк
        char[] charArray1 = new char[stringArray1.length];// первые буквы слов
        StringBuilder resultString = new StringBuilder();// массив с отсортированными словами
        // заполним массив первыми символами слов
        for(int i = 0; i < stringArray1.length; i++) {
            charArray1[i] = Character.toLowerCase(stringArray1[i].charAt(0));

        }
        // удалим из массива повторяющиеся символы
        String removeString = removeRepeatChar(String.copyValueOf(charArray1));
        charArray1 = removeString.toCharArray();// получаем новый массив символов
        // сортируем полученный массив символов
        Arrays.sort(charArray1);
        // формируем сторку для вывода
        for (char ch : charArray1) {
            for (String s : stringArray1) {
                // проверяем
                if (ch == Character.toLowerCase(s.charAt(0))) {
                    // если символ из массива и первый символ в слове равны
                    resultString.append(s).append(" ");// добавляем в строку, разделяя пробелом
                }
            }
        }
        System.out.println("resultString : " + resultString);

        /*
         * Рекурсия -----------------------------------------------------
         * 1) Метод нахождения факториала числа.
         *      Результат - число
         */
        System.out.println("факториал 5=" + getFactorialOfNumber(5));
        System.out.println("факториал 10=" + getFactorialOfNumber(10));
        /*
         * 2) Метод, находящий сумму чисел из диапазона
         *      Результат- число
         */
        System.out.println("сумма от 1 до 4 = " + getSumNumbers(1,4));
        System.out.println("сумма от 10 до 14 = " + getSumNumbers(10,14));
        /*
         * 3) Вывести все числа от 0 до value
         */
        System.out.println("числа от 0 до 10: " + getPrintNumbers(0, 10));
        System.out.println("числа от 0 до 15: " + getPrintNumbers(0, 15));
        /*
         * 4) Метод нахождения максимального значения в массиве
         */
        int[] array = {1,3,15,3,25,10,21};
        System.out.println("max value=" + getMaxValue(array));
    }

    /**
     * Удаляет из строки повторяющиеся символы. Регистр символов и пробелы игнорируются
     * @param string строка, которую нужно преобразовать
     * @return строка, содержащая только неповторяющиеся символы
     */
    private static String removeRepeatChar(String string) {
        StringBuilder result = new StringBuilder();
        char[] charArray = string.toCharArray();// преобразуем в массив
        int index = 0;
        while(index < string.length() - 1) {
            char ch = string.charAt(index);
            for (int i = index + 1; i < string.length(); i++) {
                char c = string.charAt(i);// получаем следующий символ
                if (c == ' ') continue;// пропускаем пробелы
                if (c == ch) {
                    charArray[i] = ' ';// если они равны, заменяем на пробел
                }
            }
            index++;
        }
        for (char c : charArray) {
            if (c == ' ') continue;
            result.append(c);
        }
        return result.toString();
    }

    /**
     * Вычисляет факториал числа
     * @param number число, факториал которого нужно вычислить
     * @return факториал заданного числа
     */
    private static int getFactorialOfNumber(int number) {
        if (number == 1 || number == 0) {
            // если число = 1 или 0, возвращаем 1
            return 1;
        }
        return number * getFactorialOfNumber(number - 1);
    }

    /**
     * Вычисляет сумму чисел диапазнона
     * @param a начало диапазона
     * @param b конец диапазона
     * @return вычисленная сумма чисел
     */
    private static int getSumNumbers(int a, int b) {
        // если достугнут конец диапазона, возвращаем его
        if (a == b) return b;
        return a + getSumNumbers(a + 1, b);
    }

    /**
     * Возвращает строку, содерджащую числа в диапазоне от 0 до topNumber
     * @param number нижняя граница диапазона
     * @param topNumber число, в пределах от 0 до которого нужно вывести все числа
     * @return строка, содерджащая числа в диапазоне от 0 до topNumber
     */
    private  static String getPrintNumbers(int number, int topNumber) {
        if (number == topNumber) {
            return String.valueOf(topNumber);
        }

        return String.valueOf(number).concat(" ").concat(getPrintNumbers(number + 1, topNumber));
    }

    /**
     * Возвращает маскимальное значение из переданного массива чисел
     * @param array массив чисел для поиска
     * @return найденное максимальное целое значение из массива
     */
    private static int getMaxValue(int[] array) {
        if(array.length == 0) return 0;// если массив пуст, возвращаем 0
        int maxValue = array[0];// принимаем первое значение массива за максимальное
        for(int item : array) {
            if (item > maxValue) {
                maxValue = item;
            }
        }
        return maxValue;
    }
}