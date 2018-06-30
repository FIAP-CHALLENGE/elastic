package br.com.fiap.pagseguro.load;

import br.com.fiap.pagseguro.vo.ResponseBulkInsertVO;
import org.apache.camel.Handler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class LoadTransaction {

    @Handler
    public String load(final String bulk) {

        System.out.println("Start load");

        String elasticResponse = sendToElasticsearch(bulk).toString();

        System.out.println("End load");
        return elasticResponse;
    }

    private ResponseBulkInsertVO sendToElasticsearch(final String bulk) {

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<String> request = new HttpEntity(bulk, headers);
        final RestTemplate restTemplate = new RestTemplate();

        //"http://localhost:9200/_bulk"
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        final ResponseEntity<ResponseBulkInsertVO> response = restTemplate.exchange("https://search-pntm-fon6lkaufau5dnncsv6dhmk4mq.us-east-1.es.amazonaws.com/_bulk", HttpMethod.POST, request, ResponseBulkInsertVO.class);

        final ResponseBulkInsertVO bulkInsertVO = response.getBody();

        return bulkInsertVO;
    }

}
