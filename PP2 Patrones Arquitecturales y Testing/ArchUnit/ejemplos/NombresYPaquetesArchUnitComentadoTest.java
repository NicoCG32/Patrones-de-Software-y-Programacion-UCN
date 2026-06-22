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
 * Ejemplo 2 de ArchUnit.
 *
 * Este archivo muestra reglas sencillas de nombres y ubicación por paquetes.
 * Son útiles cuando el examen pide justificar una organización por capas.
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(
        packages = "cl.ucn.solicitudes",
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class NombresYPaquetesArchUnitComentadoTest {

    /**
     * Regla de convención:
     * Toda clase ubicada en controller debe terminar con "Controller".
     *
     * Utilidad:
     * Hace que la intención de la clase sea visible desde el nombre.
     */
    @ArchTest
    public static final ArchRule controladores_deben_terminar_en_controller =
            classes()
                    .that().resideInAPackage("..controller..")
                    .should().haveSimpleNameEndingWith("Controller")
                    .because("los nombres deben reflejar la responsabilidad arquitectural");

    /**
     * Regla de ubicación:
     * Las clases llamadas Repository deben estar en infraestructura JPA.
     *
     * Utilidad:
     * Evita que aparezcan repositorios concretos en controller, view o domain.
     */
    @ArchTest
    public static final ArchRule repositorios_concretos_deben_vivir_en_infra_jpa =
            classes()
                    .that().haveSimpleNameEndingWith("Repository")
                    .should().resideInAPackage("..infra.jpa..")
                    .because("un repositorio concreto es detalle de infraestructura");

    /**
     * Regla de dependencia:
     * La infraestructura JPA no debe depender de la vista.
     *
     * Utilidad:
     * La persistencia debe poder funcionar aunque cambie JavaFX, consola o API.
     */
    @ArchTest
    public static final ArchRule jpa_no_debe_depender_de_view =
            noClasses()
                    .that().resideInAPackage("..infra.jpa..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..view..")
                    .because("la persistencia no debe conocer la interfaz de usuario");
}

