package com.ysf.local.cucumberImplementataion.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import cucumber.deps.com.thoughtworks.xstream.converters.Converter;
import cucumber.deps.com.thoughtworks.xstream.converters.MarshallingContext;
import cucumber.deps.com.thoughtworks.xstream.converters.UnmarshallingContext;
import cucumber.deps.com.thoughtworks.xstream.io.HierarchicalStreamReader;
import cucumber.deps.com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LocalDateConverter implements Converter{

    public boolean canConvert(Class type) {
        //return type.equals(LocalDate.class);
        return LocalDateTime.class.isAssignableFrom(type);
    }

    /*private static final String            DEFAULT_DATE_PATTERN = "dd-MM-yyyy";
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DateTimeFormatter.ISO_DATE_TIME.toString());*/

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
    	LocalDateTime  date = (LocalDateTime) value;
        String result = date.format(DateTimeFormatter.ISO_DATE_TIME);
        writer.setValue(result);
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    	LocalDateTime result = LocalDateTime.parse(reader.getValue(), DateTimeFormatter.ISO_DATE_TIME);
        return result;
    }

}