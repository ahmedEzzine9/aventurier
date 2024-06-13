package com.ahmed.aventurier.main;

import java.util.Scanner;

import com.ahmed.aventurier.main.exceptions.AlreadyInWoodsException;
import com.ahmed.aventurier.main.model.Aventurier;
import com.ahmed.aventurier.main.model.Card;
import com.ahmed.aventurier.main.reader.CardReader;
import com.ahmed.aventurier.main.reader.InputReader;
import com.ahmed.aventurier.main.solver.AventurierSolver;

public class AventurierRunner {
   
    public void start()  {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le chemin d'accès au fichier de la carte: ");
        String cardFilePath = scanner.nextLine();

        System.out.print("Entrez le chemin d'accès au fichier de l'aventurier: ");
        String aventurierFilePath = scanner.nextLine();

        CardReader cardReader = new CardReader();
        InputReader inputReader = new InputReader();

        AventurierSolver aventurierSolver = new AventurierSolver();
       
        Card card = cardReader.readCardFromFile(cardFilePath);
        Aventurier aventurier = inputReader.readAventurierFromFile(aventurierFilePath);

        try {
            aventurier = aventurierSolver.solve(aventurier, card);
        } catch (AlreadyInWoodsException e) {
            
            e.printStackTrace();
        }

        System.err.println("Le personnage se trouve en ("+aventurier.getX()+","+aventurier.getY()+")");

    }
}