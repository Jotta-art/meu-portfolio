import java.util.stream.Collectors;

public class ExemploMap {
//      cursos.stream().filter(c -> c.getAlunos() >= 100).map(Curso::getAlunos).forEach(System.out::println);

//      Cursos filtra os alunos que tem mais de 100, pegue a quantidade de alunos dele e soma.
//        int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
//
//        System.out.println


//        Stream<String> nomes = cursos.stream().map(Curso::getNome);
//
//        nomes.forEach(System.out::println);

//        Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() >= 1000).findAny();
//
//        Curso curso = optionalCurso.orElse(new Curso("Sei la", 20));
//        System.out.println(curso.getNome());

//        cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c -> System.out.println(c.getNome()));

//        cursos = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());

//        Map<String, Integer> map = cursos.stream().filter(c -> c.getAlunos() >= 100)
//                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));

//        Map<String, Integer> map = cursos.stream().filter(c -> c.getAlunos() >= 100)
//                .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos));

//        cursos.stream().filter(c -> c.getAlunos() >= 100)
//            .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
//            .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

//        cursos.parallelStream().filter(c -> c.getAlunos() >= 100)
//                .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
//                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

//        cursos.stream().mapToInt(c -> c.getAlunos()).average();

//        cursos.stream().mapToInt(Curso::getAlunos).average().ifPresent(System.out::println);
}
