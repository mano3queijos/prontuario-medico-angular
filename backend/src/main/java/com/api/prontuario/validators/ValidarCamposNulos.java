package com.api.prontuario.validators;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;




public class ValidarCamposNulos {

    public static List<String> validarCamposNulos(Object objeto) throws IllegalAccessException {
        List<String> invalidos = new ArrayList<>();
        Class<?> classe = objeto.getClass();
        Field[] atributos = classe.getDeclaredFields();


        for (Field atributo : atributos) {
            atributo.setAccessible(true);
            Object valor = atributo.get(objeto);

            if (valor == null) {
                if (atributo.isAnnotationPresent(Validacao.class)) {
                    Annotation[] annotations = atributo.getAnnotationsByType(Validacao.class);

                    for (Annotation annotation : annotations) {
                        Validacao validacao = (Validacao) annotation;
                        invalidos.add(validacao.descricao());
                    }
                }
            }
        }

        return invalidos;
    }
}