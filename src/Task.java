import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private UUID id;
    private Priority priority;
    private String authorName;
    private String nameTask;
    private String description;
    private LocalDate date;
    private String deadLine;


    public Task(UUID id, LocalDate date, String nameTask, Priority priority, String authorName, String description, String deadLine) {
        this.id = id;
        this.priority = priority;
        this.authorName = authorName;
        this.description = description;
        this.date = date;
        this.deadLine = deadLine;
        this.nameTask = nameTask;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNameTask() {
        return nameTask;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public UUID getId() {
        return id;
    }


    public Priority getPriority() {
        return priority;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Task id = " + id +
                "\nПриоритет = " + priority +
                "\nНазвание задачи = " + nameTask + //???????
                "\nИмя автора = " + authorName +
                "\nОписание = " + description +
                "\nДата создания = " + date +
                "\nДата сдачи задания = " + deadLine + "\n";

    }
}
