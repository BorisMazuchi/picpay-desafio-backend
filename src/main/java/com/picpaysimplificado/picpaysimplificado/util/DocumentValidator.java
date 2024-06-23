package com.picpaysimplificado.picpaysimplificado.util;

import org.springframework.stereotype.Component;

@Component
public class DocumentValidator {

    public static boolean isCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        // CPF deve ter 11 dígitos numéricos
        if (cpf.length() != 11) {
            return false;
        }

        // CPF não pode ter todos os dígitos iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        return true;
    }

    public static boolean isCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // CNPJ deve ter 14 dígitos numéricos
        if (cnpj.length() != 14) {
            return false;
        }

        // CNPJ não pode ter todos os dígitos iguais
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        return true;
    }
}
