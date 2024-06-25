public class Student {

    private String name;
    private int[] marks;

    public Student(String name, int... marks) {
        this.name = name;
        setMarks(marks);
    }

    // Проверка каждой оценки на валидность
    public void setMarks(int... marks) {
        for (int mark : marks) {
            if (mark < 2 || mark > 5) {
                throw new IllegalArgumentException("The marks should be in the range of 2 to 5");
            }
        }
        this.marks = marks;
    }

    // Конструктор копирования с изменением имени и глубоким копированием оценок
    public Student(Student student, String newName) {
        this.name = newName;
        this.marks = student.marks.clone();
    }

    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }

    public double getAvg() {
        if (marks.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        double average = (double) sum / marks.length;
        double roundRes = Math.round(average * 100.0) / 100.0;
        return roundRes;
    }

    public String excellentOrNot() {
        // 4.5 из 5 - число можно менять под нужную шкалу (но валидация сейчас стоит на диапазон 2-5)
        return (getAvg() >= 4.5) ? " Excellent student" : " Not Excellent student";
    }

    public String getAll() {
        StringBuilder marksString = new StringBuilder();
        if (marks == null || marks.length == 0) {
            return getName() + ": 0";
        }
        for (int i = 0; i < marks.length; i++) {
            if (i > 0) {
                marksString.append(", ");
            }
            marksString.append(marks[i]);
        }
        return getName() + ": " + marksString.toString() + " avg: " + getAvg() + excellentOrNot();
    }

}
