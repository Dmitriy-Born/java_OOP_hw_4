import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryTaskStorage implements TaskList{
    private List<Task> tasks = new ArrayList<>();
    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public List<Task> getAll() {
        return tasks;
    }

    @Override
    public Task getTaskNameAuthor(String authorName) {
        for (Task t : tasks){
            if(authorName == t.getAuthorName()){
                return t;
            }
        }
        return null;
    }

    @Override
    public Task getTaskId(UUID id) {
        for(Task t : tasks){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

}
