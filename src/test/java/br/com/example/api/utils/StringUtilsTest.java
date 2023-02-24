package br.com.example.api.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void test_isNullOrEmpty() {
        String target = "Teste";
        var response = StringUtils.isNullOrEmpty(target);
        Assertions.assertFalse(response);
    }

    @Test
    public void test_isNullOrEmpty_stringNula() {
        String target = null;
        var response = StringUtils.isNullOrEmpty(target);
        Assertions.assertTrue(response);
    }

    @Test
    public void test_isNullOrEmpty_stringVazia() {
        String target = "";
        var response = StringUtils.isNullOrEmpty(target);
        Assertions.assertTrue(response);
    }

    @Test
    @DisplayName("Deve retornar a mesma String com somente o primeiro caractere maiusculo")
    public void testToCaptalize() {       
        Assertions.assertEquals("Target", StringUtils.toCaptalize("target"));
        Assertions.assertEquals("Target", StringUtils.toCaptalize("tArgEt"));
        Assertions.assertEquals("Target", StringUtils.toCaptalize("TARGET"));
        Assertions.assertEquals("Target", StringUtils.toCaptalize("tarGET"));
    }

    @Test
    @DisplayName("Deve retornar vazio em caso de String nula ou vazia")
    public void testToCaptalize_stringVazia() {       
        var target = "";
        var response = StringUtils.toCaptalize(target);
        Assertions.assertEquals("", response);
    }

    @Test
    @DisplayName("Deve retornar vazio em caso de String nula ou vazia")
    public void testToCaptalize_stringNula() {
        String target = null;
        var response = StringUtils.toCaptalize(target);
        Assertions.assertEquals("", response);
    }
}
