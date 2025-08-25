package com.qa;

public class Apdex {
    
    private int totalRequisicoes;
    private int satisfatorias;
    private int toleraveis;
    private int frustrantes;

    /**
     * Construtor da classe Apdex
     * 
     * @param satisfatorias número de requisições satisfatórias (<= 500ms)
     * @param toleraveis número de requisições toleráveis (> 500ms e <= 2 segundos)
     * @param frustrantes número de requisições frustrantes (> 2 segundos)
     */
    public Apdex(int satisfatorias, int toleraveis, int frustrantes) {
        this.satisfatorias = satisfatorias;
        this.toleraveis = toleraveis;
        this.frustrantes = frustrantes;
        this.totalRequisicoes = satisfatorias + toleraveis + frustrantes;
    }

    /**
     * Calcula o valor do Apdex usando a fórmula: (S + T/2) / N
     * Onde:
     * S = requisições satisfatórias
     * T = requisições toleráveis
     * N = total de requisições
     * 
     * @return valor do Apdex calculado
     */
    public double calcularApdex() {
        if (totalRequisicoes == 0) {
            return 0.0;
        }
        return (double) (satisfatorias + (toleraveis / 2.0)) / totalRequisicoes;
    }

    /**
     * Classifica o Apdex de acordo com as faixas de classificação:
     * - Excelente: >= 0.94
     * - Bom: >= 0.85 e < 0.94
     * - Razoável: >= 0.70 e < 0.85
     * - Ruim: >= 0.50 e < 0.70
     * - Inaceitável: < 0.50
     * 
     * @return classificação do Apdex como String
     */
    public String classificarApdex() {
        double apdex = calcularApdex();
        
        if (apdex >= 0.94) {
            return "Excelente";
        } else if (apdex >= 0.85) {
            return "Bom";
        } else if (apdex >= 0.70) {
            return "Razoável";
        } else if (apdex >= 0.50) {
            return "Ruim";
        } else {
            return "Inaceitável";
        }
    }

    // Getters para acesso aos atributos (útil para testes e debug)
    
    public int getTotalRequisicoes() {
        return totalRequisicoes;
    }

    public int getSatisfatorias() {
        return satisfatorias;
    }

    public int getToleraveis() {
        return toleraveis;
    }

    public int getFrustrantes() {
        return frustrantes;
    }
}
