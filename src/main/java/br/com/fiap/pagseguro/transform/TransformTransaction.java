package br.com.fiap.pagseguro.transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Handler;

import com.google.gson.Gson;

import br.com.fiap.pagseguro.vo.TransactionVO;

public class TransformTransaction {

	public Map<String, Long> grupo = new HashMap<>();  
	
	private static final Gson GSON = new Gson();

		
    @Handler
    public List<TransactionVO> transform(final List<Map<String, String>> resultSet) {

        System.out.println("Start transform");

        final List<TransactionVO> transactions = new ArrayList<>();

        for (final Map<String, String> transactionDB : resultSet) {

            final String id = ((Object) transactionDB.get("ID")).toString();
            final String hash = transactionDB.get("hash");
            final String buyerEmail = transactionDB.get("buyer_email");
            final String sellerEmail = transactionDB.get("seller_email");
            final String value = ((Object) transactionDB.get("value")).toString();
            final String createDate = ((Object) transactionDB.get("create_date")).toString().replace(".0", "").replace(" ", "T");

            transactions.add(new TransactionVO(Long.valueOf(id), hash, buyerEmail, sellerEmail, Double.valueOf(value), createDate));

        }

        System.out.println("End transform");

        return transactions;
    }

    /*
    ##################################################################
                            CODE CHALLENGE
    ##################################################################
    */
    
    public String createBulk(final List<TransactionVO> transactions) {

        System.out.println("Start bulk");

        final StringBuilder bulk = new StringBuilder();
 
        for (final TransactionVO transaction : transactions) {

            final String index = createIndex(transaction);
            final String json = GSON.toJson(transaction);

            bulk.append(index);
            bulk.append("\n");
            bulk.append(json);
            bulk.append("\n");

        }

        System.out.println("End bulk");

        return bulk.toString();

    }

    private String createIndex(final TransactionVO transaction) {
        final String index = generateIndex(transaction);
        return String.format("{ \"index\" : { \"_index\" : \"%s\", \"_type\" : \"transaction\" , \"_id\" : \"%s\"} }", index, transaction.getId());
    }

     /*
    ##################################################################
                            CODE CHALLENGE
    ##################################################################
    */

    public String generateIndex(final TransactionVO transaction) {
    	
    	String year = transaction.getCreateDate().substring(0, 4);
    	
    	grupo.computeIfAbsent(year, k -> 0L);
    	
    	grupo.computeIfPresent(year, (k, v) -> v + 1);

    	return String.format("fiap%s%s", year, ((grupo.get(year) - 1)/5000) + 1);

    }

}