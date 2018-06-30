package br.com.fiap.pagseguro.extract;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class ExtractTransaction {

    @Value("${route.transaction.id.start}")
    private Long transactionIdStart;

    @Value("${route.transaction.id.range}")
    private Long transactionIdRange;

    private static Long actualBetweenStart;
    private static Long actualBetweenEnd;

    public List<Long> prepareSelectParameters() {

        final ArrayList<Long> selectParameters = new ArrayList<>();

        if (actualBetweenStart == null || actualBetweenEnd == null) {

        	actualBetweenStart = transactionIdStart;
        	actualBetweenEnd = transactionIdRange;

        } else {

            Long nextBetweenStart = actualBetweenEnd + 1L;
            Long nextBetweenEnd = actualBetweenEnd + transactionIdRange;

            actualBetweenStart = nextBetweenStart;
            actualBetweenEnd = nextBetweenEnd;
        }

        selectParameters.add(actualBetweenStart);
        selectParameters.add(actualBetweenEnd);


        return selectParameters;
    }

}
