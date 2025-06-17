package com.shubham.braindump.entity;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Tag {

    IDEA,
    TASK,
    REMINDER,
    RANT,
    QUESTION,
    SHOPPING_LIST,
    RANDOM;

    public static String getCommaSeparatedTags() {
        return Arrays.stream(Tag.values()).map(Enum::name).collect(Collectors.joining(", "));
    }
}
