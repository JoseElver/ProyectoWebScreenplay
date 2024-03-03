package com.exito.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPrincipalUI {

    public final Target POPUP_PROMOCION = Target.the("PopUp Producto Oferta").locatedBy ("//*[@id='wps-overlay-close-button']");
    public  final Target BTN_MENU = Target.the("Menu").locatedBy ("//div[@data-fs-menu-icon-container='true']");
    public  final Target BTN_CATEGORIA = Target.the("Categoría").locatedBy ("//p[.='Hogar y muebles']");
    public  final Target BTN_SUBCATEGORIA = Target.the("Subcategoría").locatedBy ("//a[@href='/hogar/muebles/escritorios']");
}
