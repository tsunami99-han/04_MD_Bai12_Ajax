package com.codegym.formatter;

import com.codegym.model.StatusPost;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class StatusPostFormatter implements Formatter<StatusPost> {
    @Override
    public StatusPost parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(StatusPost object, Locale locale) {
        return null;
    }
}
