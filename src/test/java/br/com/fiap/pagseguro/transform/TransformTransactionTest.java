package br.com.fiap.pagseguro.transform;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.fiap.pagseguro.vo.TransactionVO;

public class TransformTransactionTest {

	private TransactionVO transactionVO;
	
	private TransformTransaction transform = new TransformTransaction();
	
	@Before
	public void setup() {
		transactionVO = new TransactionVO(1L, "hash", "buyerEmail", "sellerEmail", 0.0D, "2014");
	}
	
	@Test
	public void generateIndexFullShard() {
		
		transform.grupo.put("2014", 5000L);
			
		assertEquals("fiap20142", transform.generateIndex(transactionVO));

	}
	
	@Test
	public void generateIndexOnLast() {
		
		transform.grupo.put("2014", 4999L);
		
		assertEquals("fiap20141", transform.generateIndex(transactionVO));
		
	}
	
}