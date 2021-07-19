package stepsDefinition;


import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class teste_Azul {
    private WebDriver navegador;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\ProjectsIntellij\\Driver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);}



    @Dado("que estou no site https://www.voeazul.com.br")
    public void que_estou_no_site_https_www_voeazul_com_br() {
        navegador.get("https://www.voeazul.com.br/");}



    @Quando("Seleciono o local de saida e de chegada")
    public void seleciono_o_local_de_saida_e_de_chegada() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(navegador, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("TCSS__tabbox-shopping")));
        navegador.findElement(By.xpath("//*[@value='OneWay']")).click();
        navegador.findElement(By.xpath("//input[@id='field-5-origin1']")).sendKeys("GRU");
        navegador.findElement(By.xpath("//input[@id='field-5-origin1']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        navegador.findElement(By.xpath("//input[@id='field-6-destination1']")).sendKeys("POA");
        navegador.findElement(By.xpath("//input[@id='field-6-destination1']")).sendKeys(Keys.ENTER);}




    @Quando("seleciono a data de partida")
    public void seleciono_a_data_de_partida() {
        navegador.findElement(By.xpath("//*[@id='field-7-departure1']")).click();
        Random aleatorio = new Random();
        int dia = aleatorio.nextInt(100);
        LocalDate dataDePartida = LocalDate.now().plusDays(dia);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        navegador.findElement(By.xpath("//input[@id='field-7-departure1']")).sendKeys((dataDePartida.format(formato)));}




    @Quando("clico no botao Buscar passagens")
    public void clico_no_botao_buscar_passagens() throws InterruptedException {
        Thread.sleep(1000);
        navegador.findElement(By.xpath("//*[@id='searchTicketsButton']")).click();}



    @Quando("clico no botao Prosseguir")
    public void clico_no_botao_prosseguir() throws InterruptedException {
        ((RemoteWebDriver) navegador).executeScript("scrollBy(0,980)", "");
        Thread.sleep(3000);
        navegador.findElement(By.xpath("(//*[@id='AvailabilityInputAvailabilityView_LinkButtonSubmit'])[2]")).click();}



    @Quando("preencho os dados dos passageiros")
    public void preencho_os_dados_dos_passageiros() throws InterruptedException {
        navegador.findElement(By.xpath("//input[@id='PassengerControlPassengerView_TextBoxFirstName_0']")).sendKeys("Bruno");
        navegador.findElement(By.xpath("//input[@id='PassengerControlPassengerView_TextBoxLastName_0']")).sendKeys("Cominotti");
        navegador.findElement(By.xpath("//*[@id='countryDiv']/div/button")).click();
        Thread.sleep(2000);
        navegador.findElement(By.xpath("//*[@id='countryDiv']/div/div/ul/li[2]/a")).click();
        navegador.findElement(By.xpath("//*[@id='informationGenderDiv_0']/div/button")).click();
        navegador.findElement(By.xpath("//*[@id='informationGenderDiv_0']/div/div/ul/li[3]/a/span[1]")).click();
        navegador.findElement(By.xpath("//*[@id='PassengerControlPassengerView_TextBoxBirthDate_0']")).sendKeys("01/02/1999");
        navegador.findElement(By.xpath("//*[@id='PassengerControlPassengerView_TextBoxEmail_0']")).sendKeys("teste123@gmail.com");
        navegador.findElement(By.xpath("//*[@id='PassengerControlPassengerView_LinkButtonSubmit']")).click();}




    @Quando("seleciono o assento")
    public void seleciono_o_assento() throws InterruptedException {
        ((RemoteWebDriver) navegador).executeScript("scrollBy(0,700)", "");
        Random aleatorio = new Random();
        int poltrona = aleatorio.nextInt(27);
        navegador.findElement(By.xpath("(//a[contains(@class,'seat -available') and @unit_value_pax_0='R$ 0,00'])[" + poltrona + "]")).click();
        Thread.sleep(5000);
        navegador.findElement(By.id("btnProsseguir")).click();}




    @Quando("clico no botao prosseguir em bagagem")
    public void clico_no_botao_prosseguir_em_bagagem() throws InterruptedException {
        Thread.sleep(2000);
        navegador.findElement(By.xpath("//button[@id='btnContinue']")).click();}




    @Quando("preencho os dados de contato")
    public void preencho_os_dados_de_contato() {
        navegador.findElement(By.xpath("//input[@id='PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxPostalCode']")).sendKeys("89806036");
        navegador.findElement(By.xpath("//input[@id='PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxAddressNumber']")).sendKeys("123");
        navegador.findElement(By.xpath("//input[@id='PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxOtherPhone']")).sendKeys("11912345678");}



    @Quando("marco a checkbox dizendo que Li e Concordo com as regras")
    public void marco_a_checkbox_dizendo_que_li_e_concordo_com_as_regras() {
        ((RemoteWebDriver) navegador).executeScript("scrollBy(0,700)", "");
        navegador.findElement(By.xpath("//label[@for='PaymentInputControlCheckoutView_CheckboxTerms']")).click();}




    @Então("valido se o botao esta habilitado")
    public void valido_se_o_botao_esta_habilitado() {
        WebElement ativo = navegador.findElement(By.xpath("//button[@class='btn btn-action btn-next']"));
        String texto = ativo.getText();
        Assert.assertEquals("Confirmar reserva", texto);
        System.out.println("="+texto+"=");}


}
