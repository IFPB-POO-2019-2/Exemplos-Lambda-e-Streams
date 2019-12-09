package com.ifpb.exemplo.visao;

import com.ifpb.exemplo.modelo.Pessoa;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
                    LocalDate.of(2000,10,30)),
            new Pessoa("444.444.444-04", "José2",
                    LocalDate.of(2008,3,1))
        );

        //Utilizando o consumer, imprimir os nomes das pessoas
//        pessoas.forEach(p-> System.out.println(p.getNome()));

        //Utilizando filter, imprimir as pessoas que começam com J
//        pessoas.stream().filter(pessoa -> pessoa.getNome()
//                .startsWith("J")).forEach(System.out::println);

        //Expandindo o exemplo anterior, removendo duplicados e limitando
//        pessoas.stream().filter(pessoa -> pessoa.getNome()
//                .startsWith("J")).distinct().limit(1)
//                .forEach(System.out::println);

        //Imprimir as pessoas maiores de 18 ordenadas pelo nascimento
//        pessoas.stream().filter(p ->
//            Period.between(
//                p.getNascimento(),LocalDate.now()).getYears()>=18)
//                .sorted(Comparator.comparing(Pessoa::getNascimento)
//                        .reversed()).forEach(System.out::println);

        //Usando collect gerar uma lista com os maiores de 18
//        List<Pessoa> maiores = pessoas.stream().filter(p ->
//            Period.between(
//                p.getNascimento(),LocalDate.now()).getYears()>=18)
//                .collect(Collectors.toList());
//        System.out.println(maiores);

        //Imprimir a pessoa com maior idade (menor localdate)
//        System.out.println(
//            pessoas.stream().filter(p ->
//            Period.between(
//                p.getNascimento(),LocalDate.now()).getYears()>=18)
//                    .min(Comparator.comparing(Pessoa::getNascimento))
//                    .get()
//        );

        //Imprimir a lista dos nomes de pessoas maiores que 18
        System.out.println(pessoas.stream().filter(p ->
            Period.between(
                p.getNascimento(),LocalDate.now()).getYears()>=18)
                .map(Pessoa::getNome).sorted()
                .collect(Collectors.toList()));

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