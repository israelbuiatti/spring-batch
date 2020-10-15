package br.com.dbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import br.com.dbc.utils.Utils;

class StringUtilsTest {

	@Test
	void testReplaceStringWithTraceByEmpty() {

		String value = "123454-8";
		String result = Utils.somenteNumero(value);
		
		assertEquals("1234548", result);
	}

	@Test
	void testReplaceStringWithCommaByPoint() throws ParseException {

		String value = "123,454";
		Double result = Utils.convertMoedaToBase(value);
		
		assertEquals(123.454, result);
	}
	
}