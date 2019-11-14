package ru.abondin.jokerconf2019.tddd.producer.util;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

public class InnValidationUtils {

    /**
     * Validate that given String is valid INN
     *
     * @param innOriginal
     * @return
     * @see <a href="https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D1%8C%D0%BD%D0%BE%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE#%D0%9D%D0%BE%D0%BC%D0%B5%D1%80%D0%B0_%D0%98%D0%9D%D0%9D">Wiki</a>
     */
    public static boolean isInnValid(@Nullable String innOriginal) {
        if (!StringUtils.hasLength(innOriginal)) {
            return false;
        }
        if (checkAllZeros(innOriginal)) {
            return false;
        }

        char[] inn = innOriginal.toCharArray();

        if (inn.length == 10) {
            return num(inn[9]) == (((
                    2 * num(inn[0]) + 4 * num(inn[1]) + 10 * num(inn[2]) +
                            3 * num(inn[3]) + 5 * num(inn[4]) + 9 * num(inn[5]) +
                            4 * num(inn[6]) + 6 * num(inn[7]) + 8 * num(inn[8])
            ) % 11) % 10);
        } else if (inn.length == 12) {
            return Integer.toString(num(inn[10])).equals(Integer.toString(((
                    7 * num(inn[0]) + 2 * num(inn[1]) + 4 * num(inn[2]) +
                            10 * num(inn[3]) + 3 * num(inn[4]) + 5 * num(inn[5]) +
                            9 * num(inn[6]) + 4 * num(inn[7]) + 6 * num(inn[8]) +
                            8 * num(inn[9])
            ) % 11) % 10)) && Integer.toString(num(inn[11])).equals(Integer.toString(((
                    3 * inn[0] + 7 * num(inn[1]) + 2 * num(inn[2]) +
                            4 * num(inn[3]) + 10 * num(inn[4]) + 3 * num(inn[5]) +
                            5 * num(inn[6]) + 9 * num(inn[7]) + 4 * num(inn[8]) +
                            6 * num(inn[9]) + 8 * inn[10]
            ) % 11) % 10));
        }

        return false;
    }

    private static int num(char l) {
        return Character.getNumericValue(l);
    }

    private static boolean checkAllZeros(String inn) {
        for (int i = 0; i < inn.length(); i++) {
            if (inn.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

}


