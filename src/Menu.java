import java.util.List;
import java.util.UUID;

public class Menu {
        static TaskManager<Task> taskManager = new TaskManager<>(new InMemoryTaskStorage());
        public Menu() {
                boolean quit = false;

                while (!quit) {

                        System.out.print("Введите номер операции для выбора действия: \n" +
                                "1. Посмотреть все задачи.\n" +
                                "2. Добавить задачу.\n" +
                                "3. Удалить задачу.\n" +
                                "4. Поиск задачи.\n" +
                                "5. Сохранить в файл. \n" +
                                "6. Загрузить из файла. \n" +
                                "7. Выход. \n" +
                                ":_> ");
                        switch (KeyScanner.getText()) {
                                case ("1") -> viewAllTask();
                                case ("2") -> addNewTask();
                                case ("3") -> deleteTask(taskManager);
                                case ("4") -> SearchTask.searchTask(taskManager);
                                case ("5") -> {
                                        try {
                                                String file = KeyScanner.getText("Введите путь и файл для экспорта");
                                                taskManager.exportTasks(file);
                                                System.out.println("Задачи успешно экспортированы.");
                                        } catch (Exception e) {
                                                System.out.println("Ошибка при экспорте задач: " + e.getMessage());
                                        }
                                }
                                case ("6") -> {try {
                                        String file = KeyScanner.getText("Введите путь и файл для импорта");
                                        taskManager = taskManager.importTasks(file);
                                        System.out.println("Задачи успешно импортированы.");

                                } catch (Exception e) {
                                        System.out.println("Ошибка при импорте задач: " + e.getMessage());
                                }}
                                case ("7") -> {
                                        System.out.println("До скорой встречи!");
                                        System.exit(0);
                                }
                                default -> System.out.println("Выберите задание из списка");
                        }

                }
        }
        public static void viewAllTask(){
                try {
                        List<Task> tasks = taskManager.getAllTasks();
                        if (tasks.isEmpty()) {
                                System.out.println("Задачи не найдены");
                        } else {
                                for (Task task : tasks) {
                                        System.out.println(task.toString());
                                }
                        }
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }

        public void addNewTask(){
                System.out.println("Добавление задачи");
                String authorName = KeyScanner.getText("Введите имя автора: ");
                String name = KeyScanner.getText("Введите название задачи: ");
                String descr = KeyScanner.getText("Введите описание задачи: ");
                String prior = KeyScanner.getText("Введите приоритет задачи: ");
                String deadLine = KeyScanner.getText("Введите количество дней, отведенных на решение задачи: ");
                Priority priority = switch (prior) {
                        case "high" -> Priority.high;
                        case "low" -> Priority.low;
                        default -> Priority.normal;
                };

                taskManager.addTask(priority, authorName, name, descr, deadLine);
        }
        static void deleteTask(TaskManager tm){
                try {
                        System.out.println("Вывести все задачи перед удалением (1-да, 2-нет)? ");
                        switch (KeyScanner.getText()){
                                case("1"): {
                                       viewAllTask();
                                        System.out.println("Какую задачу удаляем?");
                                        UUID deleteTaskChoose = UUID.fromString(KeyScanner.getText("Скопируйте и вставьте сюда ID задачи: "));
                                        System.out.println(tm.getTaskID(deleteTaskChoose));
                                }break;
                                case("2"): {

                                }break;
                                default:
                                        System.out.println("Введите 1 или 2");
                        }
                }
                catch (Exception e){
                        throw new RuntimeException(e);
                }
        }
}
