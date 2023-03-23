public interface TaskImport <T extends Task>{
    TaskManager<T> importTasks(String filePath);
}
