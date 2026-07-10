import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskModel model = new TaskModel();
        CommandLineView view = new CommandLineView();
        TaskController controller = new TaskController(model, view);

        view.ejecutarScript(controller, new String[] {
                "add:Estudiar MVC",
                "add:Separar responsabilidades",
                "list"
        });
    }
}

class CommandLineView {
    void ejecutarScript(TaskController controller, String[] comandos) {
        for (String comando : comandos) {
            controller.procesar(comando);
        }
    }

    void mostrar(String mensaje) {
        System.out.println(mensaje);
    }
}

class TaskController {
    private final TaskModel model;
    private final CommandLineView view;

    TaskController(TaskModel model, CommandLineView view) {
        this.model = model;
        this.view = view;
    }

    void procesar(String comando) {
        if (comando.startsWith("add:")) {
            model.agregar(comando.substring(4));
            view.mostrar("Tarea agregada");
            return;
        }

        if ("list".equals(comando)) {
            view.mostrar(model.resumen());
            return;
        }

        view.mostrar("Comando no reconocido");
    }
}

class TaskModel {
    private final List<String> tareas = new ArrayList<>();

    void agregar(String tarea) {
        if (tarea == null || tarea.isBlank()) {
            throw new IllegalArgumentException("La tarea es obligatoria");
        }
        tareas.add(tarea.trim());
    }

    String resumen() {
        return "Tareas registradas: " + tareas;
    }
}
