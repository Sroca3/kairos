package io.github.sroca3.kairos.kairos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MomentJsFormatter {

    private static final char UPPERCASE_A = 'A';
    private static final char UPPERCASE_D = 'D';
    private static final char UPPERCASE_Y = 'Y';

    private static final char LOWERCASE_A = 'A';
    private static final char LOWERCASE_D = 'd';
    private static final char LOWERCASE_Y = 'y';

    public static String format(LocalDateTime localDateTime, String momentJsFormatString) {
        return momentJsToDateTimeFormatterPattern(momentJsFormatString).format(localDateTime);
    }

    private static DateTimeFormatter momentJsToDateTimeFormatterPattern(String momentJsFormatString) {
        char[] originalFormat = momentJsFormatString.toCharArray();
        int originalFormatLength = momentJsFormatString.length();
        StringBuilder patternBuilder = new StringBuilder();

        for (int index = 0; index < originalFormatLength; index++) {
            Character character = originalFormat[index];

            switch (character) {
                case UPPERCASE_A:
                    patternBuilder.append(LOWERCASE_A);
                    break;
                case UPPERCASE_D:
                    patternBuilder.append(LOWERCASE_D);
                    break;
                case UPPERCASE_Y:
                    patternBuilder.append(LOWERCASE_Y);
                    break;
                default:
                    patternBuilder.append(character);
            }
        }
        return DateTimeFormatter.ofPattern(patternBuilder.toString());
    }
}
