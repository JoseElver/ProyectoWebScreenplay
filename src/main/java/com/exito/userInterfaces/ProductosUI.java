package com.exito.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductosUI {

    public final Target LBL_RESULTADOS = Target.the("Precio producto").locatedBy ("//h2[@data-testid='total-product-count']");
    public final Target BTN_PRODUCTOS = Target.the("Boton compra rapida producto").locatedBy ("//div[@data-testid='store-product-card-image']/a[@data-testid='product-link']");
    public final Target BTN_AGREGAR = Target.the("Boton agregar al carrito").locatedBy ("(//span[.='Agregar'])[1]");
    public final Target BTN_AGREGAR_MAS = Target.the("Boton agregar mas productos al carrito").locatedBy ("(//section[1]/div/div/button[2])[3]");
    public final Target BTN_CONTINUAR_COMPRANDO = Target.the("Continuar Comprando").locatedBy ("//li[4]/a");
    public final Target POPUP_PRODUCTO_AGREGADO = Target.the("PopUp Producto Agregado").locatedBy ("//*[@class='vtex-alert__close-icon pointer flex items-center pa3 white nr3 nv3']");
    public final Target LBL_NOMBRE_PRODUCTO = Target.the("Nombre Producto Agregado").locatedBy ("//h1[@class='product-title_product-title__heading__eJJqz']");
    public final Target LBL_PRECIO_PRODUCTO  = Target.the("Precio Producto Agregado").locatedBy ("(//p[@class='ProductPrice_container__price__LS1Td'])[1]");
    public final Target LBL_CANTIDAD_PRODUCTOS = Target.the("Cantidad Producto Agregado").locatedBy ("//section[2]/section[1]/section/div/div/div/p");
    public final Target LBL_ELEMENTO_INTERCEPTADO = Target.the("Elemento que intercepta el clic").locatedBy ("//div[@class='go2072408551']");
    public final Target BTN_CARRITO = Target.the("Carrito de Compras").locatedBy ("//div[@data-fs-navbar-minicart-icon-container='true']");

}
