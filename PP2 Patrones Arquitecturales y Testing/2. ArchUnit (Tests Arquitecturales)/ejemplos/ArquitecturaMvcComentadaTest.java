package cl.ucn.solicitudes.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * Ejemplo académico de test arquitectural para la Formativa PSP.
 *
 * Este archivo no prueba una operación de negocio concreta. Prueba reglas
 * estructurales: qué paquetes pueden depender de otros paquetes.
 *
 * Para usarlo en la Formativa, copiarlo a:
 *
 * src/test/java/cl/ucn/solicitudes/architecture/ArquitecturaMvcComentadaTest.java
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(
        // Paquete raíz que ArchUnit debe inspeccionar.
        packages = "cl.ucn.solicitudes",

        // Se analizan clases productivas, no clases de test.
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class ArquitecturaMvcComentadaTest {

    /**
     * Regla 1:
     * Ninguna clase del paquete controller debe depender de infraestructura.
     *
     * Razón:
     * El controlador pertenece a la capa de entrada de la aplicación. Debe
     * recibir acciones desde la vista y delegar casos de uso, no decidir cómo
     * se guarda en base de datos ni cómo se invoca un servicio externo.
     */
    @ArchTest
    public static final ArchRule controllers_no_deben_depender_de_infraestructura =
            noClasses()
                    // Selecciona clases ubicadas en cualquier paquete que contenga "controller".
                    .that().resideInAPackage("..controller..")
                    // Define la condición prohibida: depender de otras clases.
                    .should().dependOnClassesThat()
                    // La dependencia prohibida es hacia cualquier paquete que contenga "infra".
                    .resideInAnyPackage("..infra..")
                    // Explica el motivo arquitectural del test.
                    .because("el controlador debe delegar en application y no conocer detalles técnicos");

    /**
     * Regla 2:
     * La vista no debe depender de repositorios JPA.
     *
     * Razón:
     * Una interfaz JavaFX o una vista de consola no debería abrir conexiones,
     * construir repositorios ni ejecutar persistencia. Su tarea es presentar
     * datos y capturar acciones del usuario.
     */
    @ArchTest
    public static final ArchRule vista_no_debe_depender_de_jpa =
            noClasses()
                    .that().resideInAPackage("..view..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..infra.jpa..")
                    .because("la vista debe comunicarse con controller, no con persistencia");

    /**
     * Regla 3:
     * El dominio no debe depender de capas externas.
     *
     * Razón:
     * El dominio contiene reglas de negocio. Si el dominio importa controller,
     * view o infra, deja de ser estable y queda contaminado por decisiones de
     * presentación o tecnología.
     */
    @ArchTest
    public static final ArchRule dominio_no_debe_depender_de_capas_externas =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..controller..", "..view..", "..infra..")
                    .because("el dominio debe ser independiente de UI, controladores e infraestructura");

    /**
     * Regla 4:
     * Los puertos de repositorio del dominio deben ser interfaces.
     *
     * Razón:
     * Un puerto representa una necesidad del dominio o de la aplicación:
     * guardar solicitudes, buscar estudiantes, registrar historial, etc. La
     * implementación concreta pertenece a infraestructura.
     */
    @ArchTest
    public static final ArchRule puertos_de_repositorio_deben_ser_interfaces =
            classes()
                    .that().resideInAPackage("..domain.repository..")
                    .should().beInterfaces()
                    .because("los puertos definen contratos y las clases infra implementan esos contratos");

    /**
     * Regla 5:
     * La capa application no debe depender de JavaFX.
     *
     * Razón:
     * Los casos de uso deben poder ejecutarse desde una UI gráfica, una consola,
     * un test unitario o una API futura. Si application depende de JavaFX, el
     * caso de uso queda atado a una forma específica de interfaz.
     */
    @ArchTest
    public static final ArchRule application_no_debe_depender_de_javafx =
            noClasses()
                    .that().resideInAPackage("..application..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("javafx..", "org.openjfx..")
                    .because("los casos de uso deben ser independientes de la interfaz gráfica");
}

