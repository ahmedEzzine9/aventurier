package com.ahmed.aventurier;

import com.ahmed.aventurier.main.AventurierRunner;
import com.ahmed.aventurier.main.exceptions.AlreadyInWoodsException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws AlreadyInWoodsException {
        AventurierRunner aventurierRunner = new AventurierRunner();
        aventurierRunner.start();
    }
}
