package br.com.teste.utils;

import java.time.LocalDate;
import java.time.Period;

public class Utils {

    public static int calcularIdade(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataNascimento, dataAtual).getYears();
    }	
	
}
