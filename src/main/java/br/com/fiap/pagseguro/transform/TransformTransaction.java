package br.com.fiap.pagseguro.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import br.com.fiap.pagseguro.vo.TransactionVO;

public class TransformTransaction {

	public Map<String, Long> grupo = new HashMap<>();  
	
	private static final Gson GSON = new Gson();

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