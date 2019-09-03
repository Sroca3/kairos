package io.github.sroca3.kairos;

import io.github.sroca3.kairos.kairos.MomentJsFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatTester {

    static List<String> testMomentJsFormatter() throws Exception {
        return Files.readAllLines(Paths.get("test_cases"));
    }

    @ParameterizedTest
    @MethodSource
    public void testMomentJsFormatter(String testCase) {
        String[] elements = testCase.substring(testCase.indexOf(":") + 1).split(",");
        long timestamp = Long.valueOf(elements[0].trim());
        String momentJsFormatString = elements[1].trim();
        String momentJsFormattedDateTime = elements[2].trim();
        System.out.println(Arrays.toString(elements));
        LocalDateTime triggerTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timestamp),
                Clock.systemUTC().getZone()

        );

        Assertions.assertEquals(momentJsFormattedDateTime, MomentJsFormatter.format(triggerTime, momentJsFormatString));
    }
}
