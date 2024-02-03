/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casarural;

import java.awt.Color;

/**
 *
 * @author Pedro
 */
//CLASE PARA PODER COGER EL COLOR QUE EL USUARIO PONE EN LA VENTANA PRINCIPAL Y COLOCAR ESTE COLOR A TODOS LOS JFRAMES INICIALIZANDOLO EN ESTOS.
public class ColorManager {
    
    private static Color color = Color.GRAY;

    public static Color getColor() {
        return color;
    }

    public static void setColor(Color newColor) {
        color = newColor;
    }
}
