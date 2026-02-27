package pers.boyuan.thirdparty.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangBoyuan
 * @since 2022-06-14
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public Decoder feignDecoder() {
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(new ObjectMapper());

        List<MediaType> unmodifiedMediaTypeList = jacksonConverter.getSupportedMediaTypes();

        List<MediaType> mediaTypeList = new ArrayList<>(unmodifiedMediaTypeList.size() + 1);

        mediaTypeList.addAll(unmodifiedMediaTypeList);
        mediaTypeList.add(MediaType.APPLICATION_OCTET_STREAM);

        jacksonConverter.setSupportedMediaTypes(mediaTypeList);

        ObjectFactory<HttpMessageConverters> objectFactory = new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return new HttpMessageConverters(jacksonConverter);
            }
        };

        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }
}
