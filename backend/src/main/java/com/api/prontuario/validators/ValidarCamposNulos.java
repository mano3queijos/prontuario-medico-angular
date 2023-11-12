package com.api.prontuario.validators;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;




public class ValidarCamposNulos {


    public List<String> validarCamposNulos(Object objeto) {
        Class<?> classe = objeto.getClass();
        Field[] atributos = classe.getDeclaredFields();
        List<String> invalidos = new ArrayList<>();
        for (Field atributo : atributos) {
            atributo.setAccessible(true);
            Object valor;
            try {
                valor = atributo.get(objeto);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao acessar o campo", e);
            }

            if (valor == null && atributo.isAnnotationPresent(Validacao.class)) {
                Validacao validacao = atributo.getAnnotation(Validacao.class);
               invalidos.add(validacao.descricao());
            }
        }

        return invalidos;

    }
}