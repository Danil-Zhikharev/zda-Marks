public class Starter {
    // Задача 1.6.9

    public static void main(String[] args) {

        // Создаем студента Васю с оценками
        int[] vasyaMarks = {5, 5, 5};
        Student vasya = new Student("Vasya", vasyaMarks);
        System.out.println(vasya.getAll());

        // Создаем студента Петю и копируем ему оценки Васи
        Student petya = new Student("Petya", vasyaMarks);
        System.out.println(petya.getAll());

        // Создаем студента Андрея и копируем ему оценки Васи
        Student andrei = new Student(vasya, "Andrei");
        System.out.println(andrei.getAll());

        // Создаем студента Максима без оценок
        Student maksim = new Student("Maksim");
        System.out.println(maksim.getAll());

        // Изменяем оценки Васи
        vasya.getMarks()[0] = 3;

        // Выводим обновленные данные Васи и Андрея
        System.out.println("--------------");
        System.out.println(vasya.getAll());
        System.out.println(petya.getAll());
        System.out.println(andrei.getAll());
        System.out.println(maksim.getAll());

        // "Создаем" студента Алексея c IllegalArgumentException
        Student alex = new Student("Alexey", new int[]{6, 5, 1});
        System.out.println(alex.getAll());
    }
}