package com.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApdexTest {
    
    private Apdex apdex;

    @BeforeEach
    public void setup() {
        // Inicializa a instância da classe Apdex antes de cada teste
        // Os valores específicos serão definidos em cada método de teste
    }

    @Test
    public void testApdexExcelente() {
        // Teste para Apdex >= 0.94 (Excelente)
        // 376 satisfatórias, 0 toleráveis, 24 frustrantes = 400 total
        // Apdex = (376 + 0/2) / 400 = 376 / 400 = 0.94
        apdex = new Apdex(376, 0, 24);
        assertEquals("Excelente", apdex.classificarApdex());
    }

    @Test
    public void testApdexBom() {
        // Teste para Apdex >= 0.85 e < 0.94 (Bom)
        // 340 satisfatórias, 0 toleráveis, 60 frustrantes = 400 total
        // Apdex = (340 + 0/2) / 400 = 340 / 400 = 0.85
        apdex = new Apdex(340, 0, 60);
        assertEquals("Bom", apdex.classificarApdex());
    }

    @Test
    public void testApdexRazoavel() {
        // Teste para Apdex >= 0.70 e < 0.85 (Razoável)
        // 280 satisfatórias, 0 toleráveis, 120 frustrantes = 400 total
        // Apdex = (280 + 0/2) / 400 = 280 / 400 = 0.70
        apdex = new Apdex(280, 0, 120);
        assertEquals("Razoável", apdex.classificarApdex());
    }

    @Test
    public void testApdexRuim() {
        // Teste para Apdex >= 0.50 e < 0.70 (Ruim)
        // 200 satisfatórias, 0 toleráveis, 200 frustrantes = 400 total
        // Apdex = (200 + 0/2) / 400 = 200 / 400 = 0.50
        apdex = new Apdex(200, 0, 200);
        assertEquals("Ruim", apdex.classificarApdex());
    }

    @Test
    public void testApdexInaceitavel() {
        // Teste para Apdex < 0.50 (Inaceitável)
        // 100 satisfatórias, 0 toleráveis, 300 frustrantes = 400 total
        // Apdex = (100 + 0/2) / 400 = 100 / 400 = 0.25
        apdex = new Apdex(100, 0, 300);
        assertEquals("Inaceitável", apdex.classificarApdex());
    }

    @Test
    public void testCalcularApdex() {
        // Teste específico para o método calcularApdex()
        apdex = new Apdex(100, 50, 50);
        double resultadoEsperado = (100.0 + 50.0 / 2.0) / 200.0; // 125.0 / 200.0 = 0.625
        assertEquals(resultadoEsperado, apdex.calcularApdex(), 0.001);
    }

    @Test
    public void testConstrutor() {
        // Teste para verificar se o construtor está funcionando corretamente
        apdex = new Apdex(100, 50, 50);
        assertNotNull(apdex);
    }

    @Test
    public void testValoresLimite() {
        // Teste para valores limite das classificações
        // Apdex = 0.94 (limite inferior para Excelente)
        apdex = new Apdex(376, 0, 24); // (376 + 0/2) / 400 = 376 / 400 = 0.94
        assertEquals("Excelente", apdex.classificarApdex());
        
        // Apdex = 0.85 (limite inferior para Bom)
        apdex = new Apdex(340, 0, 60); // (340 + 0/2) / 400 = 340 / 400 = 0.85
        assertEquals("Bom", apdex.classificarApdex());
        
        // Apdex = 0.70 (limite inferior para Razoável)
        apdex = new Apdex(280, 0, 120); // (280 + 0/2) / 400 = 280 / 400 = 0.70
        assertEquals("Razoável", apdex.classificarApdex());
        
        // Apdex = 0.50 (limite inferior para Ruim)
        apdex = new Apdex(200, 0, 200); // (200 + 0/2) / 400 = 200 / 400 = 0.50
        assertEquals("Ruim", apdex.classificarApdex());
    }
}
