package com.qa;

public class ApdexExample {
    
    public static void main(String[] args) {
        System.out.println("=== Calculadora de Apdex - Exemplo de Uso ===\n");
        
        // Exemplo 1: Apdex Excelente
        System.out.println("Exemplo 1: Apdex Excelente");
        Apdex apdex1 = new Apdex(376, 0, 24);
        demonstrarApdex(apdex1);
        
        // Exemplo 2: Apdex Bom
        System.out.println("\nExemplo 2: Apdex Bom");
        Apdex apdex2 = new Apdex(340, 0, 60);
        demonstrarApdex(apdex2);
        
        // Exemplo 3: Apdex Razoável
        System.out.println("\nExemplo 3: Apdex Razoável");
        Apdex apdex3 = new Apdex(280, 0, 120);
        demonstrarApdex(apdex3);
        
        // Exemplo 4: Apdex Ruim
        System.out.println("\nExemplo 4: Apdex Ruim");
        Apdex apdex4 = new Apdex(200, 0, 200);
        demonstrarApdex(apdex4);
        
        // Exemplo 5: Apdex Inaceitável
        System.out.println("\nExemplo 5: Apdex Inaceitável");
        Apdex apdex5 = new Apdex(100, 0, 300);
        demonstrarApdex(apdex5);
        
        // Exemplo 6: Com requisições toleráveis
        System.out.println("\nExemplo 6: Com requisições toleráveis");
        Apdex apdex6 = new Apdex(300, 50, 50);
        demonstrarApdex(apdex6);
        
        System.out.println("\n=== Fim dos Exemplos ===");
    }
    
    /**
     * Método auxiliar para demonstrar o cálculo e classificação do Apdex
     * 
     * @param apdex instância da calculadora de Apdex
     */
    private static void demonstrarApdex(Apdex apdex) {
        System.out.println("Requisições Satisfatórias: " + apdex.getSatisfatorias());
        System.out.println("Requisições Toleráveis: " + apdex.getToleraveis());
        System.out.println("Requisições Frustrantes: " + apdex.getFrustrantes());
        System.out.println("Total de Requisições: " + apdex.getTotalRequisicoes());
        
        double valorApdex = apdex.calcularApdex();
        String classificacao = apdex.classificarApdex();
        
        System.out.printf("Valor do Apdex: %.4f%n", valorApdex);
        System.out.println("Classificação: " + classificacao);
        
        // Demonstração da fórmula
        double s = apdex.getSatisfatorias();
        double t = apdex.getToleraveis();
        double n = apdex.getTotalRequisicoes();
        double resultado = (s + t/2.0) / n;
        
        System.out.printf("Fórmula: (%.0f + %.0f/2) / %.0f = %.4f%n", s, t, n, resultado);
    }
}
