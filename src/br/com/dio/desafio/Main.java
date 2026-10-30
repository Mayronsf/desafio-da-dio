package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Curso Java", "Fundamentos da linguagem Java", 8);
        Curso curso2 = new Curso("Curso POO", "Orientação a Objetos com Java", 4);
        Mentoria mentoria = new Mentoria("Mentoria de Java", "Tirando dúvidas de POO", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        System.out.println("Bootcamp: " + bootcamp.getNome()
                + " (" + bootcamp.getDataInicial() + " a " + bootcamp.getDataFinal() + ")");
        System.out.println("XP total disponível: " + bootcamp.calcularXpTotal());

        Dev camila = new Dev("Camila");
        camila.inscreverBootcamp(bootcamp);
        camila.progredir();
        camila.progredir();

        Dev joao = new Dev("João");
        joao.inscreverBootcamp(bootcamp);
        joao.progredir();
        joao.progredir();
        joao.progredir();

        for (Dev dev : bootcamp.getDevsInscritos()) {
            System.out.println("\n-------- " + dev.getNome() + " --------");
            System.out.println("Conteúdos inscritos: " + dev.getConteudosInscritos());
            System.out.println("Conteúdos concluídos: " + dev.getConteudosConcluidos());
            System.out.println("XP: " + dev.calcularTotalXp());
            System.out.printf("Progresso: %.1f%%%n", dev.calcularProgresso());
        }

        // Evolução: ranking dos devs por XP
        System.out.println("\n======== Ranking ========");
        bootcamp.getDevsInscritos().stream()
                .sorted(Comparator.comparingDouble(Dev::calcularTotalXp).reversed())
                .forEach(dev -> System.out.println(dev.getNome() + " - " + dev.calcularTotalXp() + " XP"));
    }
}
