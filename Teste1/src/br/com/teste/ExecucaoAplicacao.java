package br.com.teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.teste.entity.Funcionario;
import br.com.teste.utils.Utils;

public class ExecucaoAplicacao {
    public static void main(String[] args) {
    	DateTimeFormatter formatterDt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // 3.1 – Inserir todos os funcionários na mesma ordem e informações da tabela
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 – Remover funcionário João da lista
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        // 3.3 – Imprimir todos os funcionários com todas suas informações
        System.out.println("*********Dados de Funcionários************");
        
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        // 3.4 – Os funcionários receberam 10% de aumento de salário
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.1"));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        }

        // 3.5 – Agrupar os funcionários por função em um MAP
        Map<String, List<Funcionario>> funcionariosAgrupadosPorFuncao = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            
            if (!funcionariosAgrupadosPorFuncao.containsKey(funcionario.getFuncao().trim())) {
            	funcionariosAgrupadosPorFuncao.put(funcionario.getFuncao().trim(), new ArrayList<>());
            }
            
            funcionariosAgrupadosPorFuncao.get(funcionario.getFuncao().trim()).add(funcionario);            
        }

        // 3.6 – Imprimir os funcionários, agrupados por função
        System.out.println("  ");
        System.out.println("*********Funcionários agrupados por função************");
        
        for (String funcao : funcionariosAgrupadosPorFuncao.keySet()) {
            System.out.println("-->> Função: " + funcao);
            
            List<Funcionario> funcionariosDaFuncao = funcionariosAgrupadosPorFuncao.get(funcao);
            
            for (Funcionario funcionario : funcionariosDaFuncao) {
                System.out.println("  Nome: " + funcionario.getNome() +
                				   " - Data de Nascimento: " + formatterDt.format(funcionario.getDataNascimento())+
                                   " - Salário: " + funcionario.getSalario());
            }
        }
        
        System.out.println("  ");

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("*********Funcionários com aniversário no mês 10 e 12*********");
        
        for (Funcionario funcionario : funcionarios) {
            
            if (funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12) {
                System.out.println("  Nome: " + funcionario.getNome() +
     				   " - Data de Nascimento: " + formatterDt.format(funcionario.getDataNascimento()));
            }
            
        }
        
        System.out.println("  ");
        
        

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade
        System.out.println("*********Funcionário com maior idade*********");
        
        Funcionario funcionarioComIdadeMaior = funcionarios.get(0);
        for (Funcionario funcionario : funcionarios) {
        	
            if (Utils.calcularIdade(funcionario.getDataNascimento()) > Utils.calcularIdade(funcionarioComIdadeMaior.getDataNascimento())) {
            	funcionarioComIdadeMaior = funcionario;
            }
            
        }

        System.out.println("Nome: " + funcionarioComIdadeMaior.getNome() +
                           ", Idade: " + Utils.calcularIdade(funcionarioComIdadeMaior.getDataNascimento()));        
        System.out.println("  ");
        

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética
        System.out.println("*********Funcionário em ordem alfabética*********");
        
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
        }
        
        System.out.println("  ");

        // 3.11 – Imprimir o total dos salários dos funcionários
        System.out.println("*********Funcionário em ordem alfabética*********");
        
        BigDecimal totalDosSalarios = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
        	totalDosSalarios = totalDosSalarios.add(funcionario.getSalario());
        }
        
        System.out.println("Total de salários: " + totalDosSalarios);
        System.out.println("  ");
        

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário
        System.out.println("*********Quantidade de salários mínimos*********");
        
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        for (Funcionario funcionario : funcionarios) {
            BigDecimal quantidadeSalariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println("Nome: " + funcionario.getNome() + " - Quantidade: " + quantidadeSalariosMinimos);
        }
        
    }
}
