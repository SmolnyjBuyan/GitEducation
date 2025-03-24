package ru.smolny;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class MyCustomPlugin implements Plugin<Project>{
    @Override
    public void apply(Project target) {
        target.getTasks().create("MyCustomTask", MyCustomTask.class);
    }
}

class MyCustomTask extends DefaultTask {
    @TaskAction
    public void myCustomAction() {
        System.out.println("Hello from MyCustomTask!");
    }
}
