import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskManager <T extends Task>{

    private TaskList<T> taskList;
    private TaskImport taskImport;
    private TaskExport taskExport;


    public TaskManager(TaskList<T> taskList) {
        this.taskList = taskList;
    }

    public TaskManager(TaskList<T> taskList, TaskExport taskExport, TaskImport taskImport){
        this.taskList = taskList;
        this.taskExport = taskExport;
        this.taskImport = taskImport;
    }

    public void addTask (Priority priority, String authorName, String nameTask, String description, String deadLine){
        LocalDate date1 = LocalDate.now();

        int i = Integer.parseInt (deadLine);
        int dateDead = date1.getDayOfMonth()+i;
        String newDate = String.valueOf(dateDead);

        String date2 = date1.getYear()+"-0"+date1.getMonthValue()+"-"+newDate;

        T task = (T) new Task(UUID.randomUUID(), date1, nameTask, priority, authorName, description, date2);
        taskList.add(task);
    }

    public List<T> getAllTasks() {
        return taskList.getAll();
    }

    public List<T> getTaskNameAuthor(String authorName){
        System.out.println(taskList.getTaskNameAuthor(authorName));
        return taskList.getAll().stream().filter(task -> task.getAuthorName() == authorName).collect(Collectors.toList());
    }

    public List<T> getTaskPriority(Priority priority){
        return taskList.getAll().stream().filter(task -> task.getPriority() == priority).collect(Collectors.toList());
    }

    public T getTaskID (UUID id){
        return taskList.getTaskId(id);
    }

    public void exportTasks(String filePath){
        List<T> tasks = taskList.getAll();

    }

    public TaskManager<Task> importTasks(String filePath){
        return taskImport.importTasks(filePath);
    }

}
