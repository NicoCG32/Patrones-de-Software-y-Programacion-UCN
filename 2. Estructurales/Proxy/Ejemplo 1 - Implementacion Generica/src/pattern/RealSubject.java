package pattern;

public class RealSubject implements Subject {
    public RealSubject() { System.out.println("Creando recurso costoso: imagen pesada"); }
    public void request() { System.out.println("Usando recurso real: imagen pesada"); }
}
