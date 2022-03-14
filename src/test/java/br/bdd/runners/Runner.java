package br.bdd.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/aprender_cucumber.feature", //mapeia as features
        glue = "br.bdd.steps", //mapeia as steps
        plugin = "pretty", //mostra as descrições na hora de executar o junit
        monochrome = false, //cor nas descrições
        snippets = SnippetType.CAMELCASE,
        dryRun = false // True - ele apenas valida o mapeamento e não executa os testes
)
public class Runner {

}
