package com.filtrojava;

import com.filtrojava.console.Initializer;
import com.filtrojava.genero.adapter.in.GeneroConsoleAdapter;

public class Main {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();

        GeneroConsoleAdapter generoConsoleAdapter= initializer.startGeneroModule();

        generoConsoleAdapter.start();
    }


}