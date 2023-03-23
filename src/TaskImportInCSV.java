import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

public class TaskImportInCSV implements TaskImport{

    @Override
    public TaskManager<Task> importTasks(String filePath) {
        TaskList<Task> taskStorage = new InMemoryTaskStorage();
        TaskExport taskExport = new TaskExportInCSV();
        TaskImport taskImport = new TaskImportInCSV();
        TaskManager<Task> taskManager = new TaskManager<>(taskStorage, taskExport, taskImport);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                UUID id = UUID.fromString(parts[1]);
                String description = parts[2];
                Priority priority = Priority.valueOf(parts[3]);
                String authorName = parts[4];
                String name = parts[5];
                String deadLine = parts[6];
                taskManager.addTask(priority,authorName,name, description, deadLine);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return taskManager;
    }
}
