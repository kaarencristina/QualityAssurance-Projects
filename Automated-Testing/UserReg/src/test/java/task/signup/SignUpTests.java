package task.signup;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("testes automatizados da funcionalidade de signup")
public class SignUpTests {
    @Test
    @DisplayName("Registrar um novo usuario com dados validos")
    public void testRegistrarUmNovoUsuarioComDadosValidos(){
        //abrir o chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        //abrir o site do taskit
        navegador.get("http://www.juliodelima.com.br/taskit/");

        //vou clicar no botao que tem o id = signup
        navegador.findElement(By.id("signup")).click();

        //digitar o nome no campo com id=name-sign-up
        navegador.findElement(By.id("name-sign-up")).sendKeys("Pedro");
        //digitar o login no campo com id=login-sign-up
        navegador.findElement(By.id("login-sign-up")).sendKeys("Pedro9989");

        //digitar a senha no campo com id=password-sign-up
        navegador.findElement(By.id("password-sign-up")).sendKeys("123");
        //clicar no botao save com id=btn-submit-sign-up

        navegador.findElement(By.id("btn-submit-sign-up")).click();

        //validar que o nome do usuario foi apresentado no elemento onde a classe eh =me
        String saudacaoAtual=navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, Pedro", saudacaoAtual);

    }

}
