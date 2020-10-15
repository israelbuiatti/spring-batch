package br.com.dbc.utils;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Utils {
	
	static public Double convertMoedaToBase(String valor) throws ParseException {
		
		DecimalFormat decimal = new DecimalFormat("###,###,###,##0.00");
        
        return decimal.parse(valor).doubleValue();
		
	}
	
	static public String somenteNumero(String valor) {
		return valor.replaceAll("\\D+","");
	}

}
