package com.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SubirArchivos implements Interaction {

    private String rutaArchivo;

    public SubirArchivos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Path ruta = Paths.get(rutaArchivo).toAbsolutePath();
        String rutaDefinitiva = ruta.toString();
        StringSelection ss = new StringSelection(rutaDefinitiva);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = null;

        try {

            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static SubirArchivos on(String rutaArchivo) {
        return new SubirArchivos(rutaArchivo);
    }
}