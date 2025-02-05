package br.com.front.serverest.dev;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;




@DisplayName("Testando a funcionalidade de registrar Conta , Realizar login e Adicionar item ao carrinho , ")
public class RegistrarCadastroTest {
    // driver Navegador foi declarado como variavel para poder ser acessado por todos os metodos //
    private static WebDriver driveNavegador;

    // aqui vamos abrir o navegador antes de todos os metódos para que os metodos ultilizam a mesma seção do navegador//
    @BeforeAll
    public static void testAbrirNavegador(){
        driveNavegador = new ChromeDriver();
    }
    @Order(1)
    @Test
    @DisplayName("Dado que eu esteja na tela de login quando clicar no botão de registrar" +
            " quando inserir os dados validos para cadastro então  o sistema deve me notificar uma mensagem de cadastro realizado com sucesso ")
    public void testRegistrarConta(){

        // abrir o site para teste
        driveNavegador.get("https://front.serverest.dev/login");

        driveNavegador.manage().window().maximize();

        //  vou clicar no campo que tem classe registrar
        driveNavegador.findElement(By.cssSelector(".btn.btn-link")).click();

        // agora vamos digitar nome do usuario a ser criado //
        driveNavegador.findElement(By.id("nome"))
                .sendKeys("Joaovitor");

        //vou digitar o email do usuario  //
        driveNavegador.findElement(By.id("email"))
                .sendKeys("joaao@gmail.com");

        // agora vaamos digitar a senha do usuario//
        driveNavegador.findElement(By.id("password"))
                .sendKeys("88294179joao");

        // agora vamos clicar no botão  cadastrar//
        driveNavegador.findElement(By.cssSelector(".btn.btn-primary")).click();

        // Esperar a página de home carregar
        WebDriverWait wait = new WebDriverWait(driveNavegador,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("/home"));

        // agora vamos sair da conta //
        driveNavegador.findElement(By.cssSelector("button[data-testid='logout']")).click();

        System.out.println("Teste concluido com sucesso");


    }

    @Test
    @Order(2) // Ordem para teste ser execultado
    @DisplayName("Dado que eu esteja na tela de login , quando inserir email e senha validoss então o sistema deverar me retorna a pagina home do site ")
    public void testFazerLoginUsuario(){

        //Abrir o navegador em tela cheia//
        driveNavegador.manage().window().maximize();

        driveNavegador.get("https://front.serverest.dev/login");
        // Agora vamos pega email do usuario para realizar o login//
        driveNavegador.findElement(By.id("email"))
                .sendKeys("joaao@gmail.com");

        // Agora vamos pega senha do usuario pra realizar o login//

        driveNavegador.findElement(By.id("password"))
                .sendKeys("88294179joao");

        // Agora vamos clicar no botão entrar para acessar o sistema //
        driveNavegador.findElement(By.cssSelector(".btn.btn-primary"))
                .click();

        // Espera a pagina home carregar
        WebDriverWait wait = new WebDriverWait(driveNavegador,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("/home"));

        // agora vamos sair da conta //
        driveNavegador.findElement(By.cssSelector("button[data-testid='logout']"))
                .click();


    }
    @Test
    @Order(3)
    @DisplayName("Dado que eu esteja na tela de login , quando realizo o login com dados validos emaill e senha " +
            "entao devo vizualizar tela inicial e quando adicionar o item no carrinho então devo ver o item adicionado na minha lista de compras")
    public void testAdicionarItemNoCarrinho(){

        driveNavegador.get("https://front.serverest.dev/login");

        driveNavegador.manage().window().maximize();

        driveNavegador.findElement(By.id("email"))
                        .sendKeys("joaao@gmail.com");

        driveNavegador.findElement(By.id("password"))
                .sendKeys("88294179joao");

        driveNavegador.findElement(By.cssSelector(".btn.btn-primary"))
                .click();

        WebDriverWait wait = new WebDriverWait(driveNavegador , Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlContains("/home"));

        //agora vamos adicionar o item para carrinho do usuario //
        driveNavegador.findElement(By.cssSelector("button[data-testid='adicionarNaLista']"))
                .click();

        WebDriverWait listaCompras = new WebDriverWait(driveNavegador , Duration.ofSeconds(60));
        listaCompras.until(ExpectedConditions.urlContains("/minhaListaDeProdutos"));

        //retorna para pagina inicial
        driveNavegador.findElement(By.cssSelector("button[data-testid='paginaInicial']"))
                        .click();


    }

    @Test
    @Order(4)
    @DisplayName("Dado que eu esteja na tela inicial  do site Quando pesquisar pelo  nome do produto" +
            "Então sistema  deverar exibir  apenas o produto pesquisado")
    public void  testPesquisarProduto(){

        //Abrir o navegador
        driveNavegador.get("https://front.serverest.dev/login");

        // maximizar a tela do navegador
        driveNavegador.manage().window().maximize();

        // inseir o campos de login e senha validos

        driveNavegador.findElement(By.id("email"))
                .sendKeys("joaao@gmail.com");

        driveNavegador.findElement(By.id("password"))
                .sendKeys("88294179joao");

        driveNavegador.findElement(By.cssSelector(".btn.btn-primary"))
                        .click();

        WebDriverWait wait = new WebDriverWait(driveNavegador , Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlContains("/home"));

        // inserir o nome do produto
        driveNavegador.findElement(By.cssSelector(".form-control.my-5.mx-3.my-sm-0"))
                .sendKeys("Teste_44");

        // pesquisar pelo produto digitado na barra de pesquisa
        driveNavegador.findElement(By.cssSelector("button[data-testid='botaoPesquisar']"))
                .click();









    }




}
