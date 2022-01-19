package com.qinweizhao.system.config;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局日期格式化
 *
 * @author qinweizhao
 * @since 2021/12/21
 */
@JsonComponent
public class DateFormatConfig {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DateFormatConfig() {
    }

    /**
     * 日期格式化
     */
    public static class DateJsonSerializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(DATE_FORMAT.format(date));
        }
    }

    /**
     * 解析日期字符串
     */
    public static class DateJsonDeserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            try {
                return DATE_FORMAT.parse(jsonParser.getText());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
