package ua.goit.gojava;

/**
 * Created by admin on 03.04.2016.
 */
public class SuperCiphers {

    private static final int ALPHABET_POWER = 65536;

    /**
     * Алгоритм шифрования по методу Цезаря
     *
     * @param string     строка подлежащая шифрованию или дешифрованию
     * @param shift      ключ шифрования
     * @param encryption действие - true - шифрование, false - дешифрование
     * @return обработанная строка
     */
    public static String Caesar(String string, int shift, boolean encryption) {

        if (encryption) {
            //Алгоритм шифрования
            char[] charString = string.toCharArray();       //массив символов из входной строки
            String result = "";                             //для зашифрованной строки

            //Шифрование
            for (int i = 0; i < charString.length; i++) {

                /*
                * формула: y = (x + k)MOD ap
                * где:  y - зашифрованный символ
                *       x - шифруемый символ
                *       k - сдвиг относительно шифруемого символа
                *       ap - мощность алфавита (к-во символов)
                */
                charString[i] = (char) ((charString[i] + shift) % ALPHABET_POWER);

                //Формирование строки с шифрованным текстом
                result += charString[i];
            }
            return result;

        } else {
            //Алгоритм дешифрования
            char[] charString = string.toCharArray();       //массив символов из входной строки
            String result = "";                             //для расшифрованной строки

            //Дешифрование
            for (int i = 0; i < charString.length; i++) {

                /*
                * формула: x = (ap + (y - k))MOD ap
                * где:  y - зашифрованный символ
                *       x - расшифрованный символ
                *       k - сдвиг относительно шифруемого символа
                *       ap - мощность алфавита (к-во символов)
                */
                charString[i] = (char) ((charString[i] - shift) % ALPHABET_POWER);

                //Формирование строки с шифрованным текстом
                result += charString[i];
            }
            return result;
        }
    }
}
