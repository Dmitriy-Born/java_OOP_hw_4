import java.util.List;

public class SearchTask {
    static void searchTask(TaskManager tm) {
        List<Task> tasks = tm.getAllTasks();
        System.out.print("Введите метод поиска: \n" +
                "1. Поиск по приоритету.\n" +
                "2. Поиск по id.\n" +
                "3. Выход в основное меню.\n");

        switch (KeyScanner.getText()) {
            case ("1") -> {

                String nameAuthor = KeyScanner.getText("Введите приоритет, по которому нужно найти задачу: ");
                Priority priority = Priority.valueOf(nameAuthor.toLowerCase());
                List<Task> taskPriority = tm.getTaskPriority(priority);
                if (taskPriority.isEmpty()){
                    System.out.println("Задачи не найдены");
                }
                else {
                    for(Task t : taskPriority) {
                        System.out.println(t);
                    }
                }
            }
            case ("2") -> {
                System.out.println("2");
            }
            case ("3") -> {
                System.out.println("3");
            }
        }
    }
}
