package com.company.project.runners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/login") // Reemplaza a 'features'

// 1. Configuración del GLUE (Dónde están tus Step Definitions)
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "com.company.project.stepDefinitions, com.company.project.hooks"
)

// 2. Configuración de los TAGS (Filtros de ejecución, ej: @Regresion o @Login)
@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value = "not @Ignore" // Si está vacío o no usas tags por ahora, puedes borrar este bloque entero
)

// 3. Configuración del Reporteador Oficial de Serenity
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel"
)

public class LoginTestSuite {



}
