import java.util.List;

public interface TaskExport <T extends Task>{
    void export(List<T> tasks, String filePath);
}
