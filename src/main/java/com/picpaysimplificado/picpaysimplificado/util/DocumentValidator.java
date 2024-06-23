package com.picpaysimplificado.picpaysimplificado.util;

import org.springframework.stereotype.Component;

@Component
public class DocumentValidator {

    public static boolean isCPFOrCNPJ(String document) {
        return isCPF(document) || isCNPJ(document);
    }

    public static boolean isCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        return !cpf.matches("(\\d)\\1{10}");
    }

    public static boolean isCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        return !cnpj.matches("(\\d)\\1{13}");
    }
}
