package pattern;

public class ConcreteProcess extends ProcessTemplate {
    protected void executeSpecificStep() {
        System.out.println("importacion: paso variable concreto");
    }
}
