package br.com.fiap.pagseguro.route;

import br.com.fiap.pagseguro.extract.ExtractTransaction;
import br.com.fiap.pagseguro.load.LoadTransaction;
import br.com.fiap.pagseguro.transform.TransformTransaction;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TransactionRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Start
        from("timer:start?repeatCount=0")

                // Prepare extract
                .bean(ExtractTransaction.class)

                // Extract from database
                .to("sql:" + "select ID, HASH, CREATE_DATE, BUYER_EMAIL, SELLER_EMAIL, VALUE from transaction where id between # and #" + "?dataSource=dataSource&outputClass=br.com.fiap.pagseguro.vo.TransactionVO")

                // Validate results
                .choice().when(simple("${body.size} > 0"))

                // Create bulk to elasticsearch
                .bean(TransformTransaction.class, "createBulk")

                // Send bulk to elasticsearch
                .bean(LoadTransaction.class)

            // End
            .end();
    }
}
