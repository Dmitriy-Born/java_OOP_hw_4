import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface TaskList <T extends Task>{
    void add (T task);

    List<T> getAll();

    T getTaskNameAuthor(String authorName);

    T getTaskId (UUID id);

}
