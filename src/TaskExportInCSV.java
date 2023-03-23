import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TaskExportInCSV implements TaskExport<Task>{
    @Override
    public void export(List<Task> tasks, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))){
            for (Task t : tasks){
                writer.printf("%s,%s,%s,%s,%s,%s,%s",t.getId(), t.getDate(), t.getAuthorName(), t.getNameTask(), t.getPriority(), t.getDescription(), t.getDeadLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
