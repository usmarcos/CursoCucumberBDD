import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.deps.com.thoughtworks.xstream.converters.basic.DateConverter;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumber {
    @Dado ("^que criei o arquivo corretamente$")
    public void queCrieiOArquivoCorretamente() {

    }

    @Quando("^executá-lo$")
    public void executáLo() {

    }

    @Então("^a especificação deve finalizar com sucesso$")
    public void aEspecificaçãoDeveFinalizarComSucesso() {

    }

    //Cenário do contador ------------------------------------------------------------------------------------------
    private int contador = 0;

    @Dado("^que o valor do contador é (\\d+)$")
    public void queOValorDoContadorÉ(int arg1) {
        contador = arg1;
    }

    @Quando("^eu incrementar em (\\d+)$")
    public void euIncrementarEm(int arg1) {
        contador = contador + arg1;
    }

    @Então("^o valor do contador será (\\d+)$")
    public void oValorDoContadorSerá(int arg1) {
        Assert.assertEquals(arg1, contador);
    }

    //Cenário de entrega ------------------------------------------------------------------------------------------
    Date entrega = new Date();

    @Dado("^que a entrega é dia (.*)$")
    public void queAEntregaÉDia(Date data) {
       entrega = data;
        System.out.println(entrega);
    }

    // o "." significa que aceita qualquer caracter
    @Quando("a entrega atrasar em (\\d+) (dia||mes||dias||meses)$")
    public void aEntregaAtrasarEmDias(Integer int1, String tempo) {
        Calendar cal = Calendar.getInstance();
        //transformei a data em calendar e enviei pra variável
        cal.setTime(entrega);
        if(tempo.equals("dias")){
            cal.add(Calendar.DAY_OF_MONTH, int1);
        }
        if(tempo.equals("meses")){
            cal.add(Calendar.MONTH, int1);
        }
        entrega = cal.getTime();

    }

    @Então("a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatada = format.format(entrega);
    Assert.assertEquals(data, dataFormatada);
    }

// Cenário do desafio ------------------------------------------------------------------------------------------


     @Dado("^que o ticket( especial)? é (A.\\d{3})$")
    public void queOTicketÉA(String tipo, String arg1) {

    }

    @Dado("^que o valor da passagem é R\\$ (.*)$")
    public void queOValorDaPassagemÉR$(Double numero) {

    }

    @Dado("^que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String arg1) {

    }
    //aceitando telefone que começa com 9
    @Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
    public void queOTelefoneDoPassageiroÉ(String telefone) {

    }

    @Quando("^criar os steps$")
    public void criarOsSteps() {

    }

    @Então("^o teste vai funcionar$")
    public void oTesteVaiFuncionar() {

    }
}
