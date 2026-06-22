package cl.ucn.solicitudes.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * Este test debe FALLAR en el proyecto base.
 *
 * Su propósito es evidenciar que la arquitectura MVC fue degradada.
 *
 * En JUnit 4 es importante usar @RunWith(ArchUnitRunner.class),
 * porque de lo contrario las reglas @ArchTest pueden no ejecutarse.
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(
        packages = "cl.ucn.solicitudes",
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class ArquitecturaMvcTest {

    @ArchTest
    public static final ArchRule controllers_no_deben_depender_de_infraestructura =
            noClasses()
                    .that().resideInAPackage("..controller..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..infra..")
                    .because("en MVC el controlador no debe depender directamente de infraestructura concreta");

    @ArchTest
    public static final ArchRule vista_no_debe_depender_de_persistencia =
            noClasses()
                    .that().resideInAPackage("..view..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..infra.jpa..")
                    .because("la vista solo debe delegar acciones al controlador");

    @ArchTest
    public static final ArchRule dominio_no_debe_depender_de_capas_externas =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..controller..", "..view..", "..infra..")
                    .because("el dominio debe permanecer independiente de capas externas");
}
