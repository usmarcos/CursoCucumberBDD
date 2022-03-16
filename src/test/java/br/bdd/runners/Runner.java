package br.bdd.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/alugar_filme.feature", //mapeia as features
        glue = "br.bdd.steps", //mapeia as steps
        //entre chaves executa essa tag ou outra após a virgula
        tags = {""}, //se colocar apenas a tag só irá executar este e com o "not" ele ignora a tag
        //mostra as descrições na hora de executar, como um relatório
        //cria relatório em html no target
        plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        monochrome = false, //cor nas descrições
        snippets = SnippetType.CAMELCASE,
        dryRun = false // True - ele apenas valida o mapeamento e não executa os testes
)
public class Runner {

}

