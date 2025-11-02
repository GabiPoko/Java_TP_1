package com.chadacademy;

import com.chadacademy.service.menu.MenuService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        MenuService menu = new MenuService();
        menu.iniciar(); // sólo esto
    }
}
