package com.exito.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoUI {

    public final Target INPUT_EMAIL = Target.the("Email").locatedBy ("//input[@name='email']");
    public final Target BTN_CONFIRMAR = Target.the("Confirmar").locatedBy ("//button[@class='exito-checkout-io-0-x-preLoginActiveButton']");
    public final Target LBL_CARRITO = Target.the("Carrito de Compras").locatedBy ("//*[@class='exito-checkout-io-0-x-pageTitle']");

    public final Target LBL_TOTAL_PRODUCTOS= Target.the("Confirmar").locatedBy ("//div[@class='exito-checkout-io-0-x-itemCartContent']");

    public static Target LBL_NOMBRE_PRODUCTO(String producto) { return Target.the("Nombre Producto ").locatedBy("//span[contains(text(),'"+ producto +"')]");}

    public static By LBL_VALOR_PRODUCTOS(String producto) { return By.xpath("(//span[contains(text(),'"+ producto +"')]//following::span)[1]");}

    public static By LBL_CANTIDAD_PRODUCTO(String producto) { return By.xpath("(//span[contains(text(),'"+ producto +"')]//following::span)[2]");}

}
