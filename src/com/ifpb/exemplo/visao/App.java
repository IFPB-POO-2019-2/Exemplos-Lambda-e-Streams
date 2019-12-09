package com.ifpb.exemplo.visao;

import com.ifpb.exemplo.modelo.Pessoa;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("111.111.111-01", "João",
                    LocalDate.of(1992,1,3)),
            new Pessoa("333.333.333-03", "Maria",
                    LocalDate.of(1989,3,5)),
            new Pessoa("222.222.222-02", "Ana",
                    LocalDate.of(1992,2,4)),
            new Pessoa("444.444.444-04", "José",
                    LocalDate.of(2008,3,1)),
            new Pessoa("555.555.555-05", "Jussara",
                    LocalDate.of(2000,10,30))
        );

        //Classe interna anônima
//        Comparator<Pessoa> comparadorPorNome = new Comparator<Pessoa>() {
//            @Override
//            public int compare(Pessoa o1, Pessoa o2) {
//                return o1.getNome().compareTo(o2.getNome());
//            }
//        };

//        //Ordenação com lamda
//        Collections.sort(pessoas,
//                (o1, o2) -> o1.getNome().compareTo(o2.getNome()));
//
//        System.out.println(pessoas);
//
//        //Ordenação com method reference
//        pessoas.sort(Comparator.comparing(Pessoa::getCpf));
//
//        System.out.println(pessoas);

    }

    //Classe interna
    private static class ComparadorPorNome implements Comparator<Pessoa> {
        @Override
        public int compare(Pessoa o1, Pessoa o2) {
            return o1.getNome().compareTo(o2.getNome());
        }
    }


}