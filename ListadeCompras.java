/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadecompras;

/**
 *
 * @author lucas
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ListadeCompras {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        boolean sair = false;

        while (!sair) {
            System.out.println("\nSelecione uma opção a seguir");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Remover item");
            System.out.println("3 - Visualizar lista");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Deletar lista inteira");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");

            int op = lerInt(sc);

            switch (op) {

                case 1:
                    do {
                        System.out.print("Item: ");
                        String item = sc.nextLine().trim();
                        if (!item.isEmpty()) lista.add(item);
                        System.out.print("Adicionar outro? (s/n): ");
                    } while (lerSim(sc));
                    break;

                case 2: 
                    if (lista.isEmpty()) System.out.println("Lista vazia.");
                    else {
                        mostrar(lista);
                        System.out.print("Número do item: ");
                        int r = lerInt(sc);
                        if (r >= 1 && r <= lista.size()) lista.remove(r - 1);
                    }
                    break;

                case 3: 
                    if (lista.isEmpty()) System.out.println("Lista vazia.");
                    else mostrar(lista);
                    break;

                case 4: 
                    if (!lista.isEmpty()) {
                        mostrar(lista);
                        System.out.print("Número do item: ");
                        int a = lerInt(sc);
                        if (a >= 1 && a <= lista.size()) {
                            System.out.print("Novo valor: ");
                            String novo = sc.nextLine().trim();
                            if (!novo.isEmpty()) lista.set(a - 1, novo);
                        }
                    } else System.out.println("Lista vazia.");
                    break;

                case 5: 
                    if (!lista.isEmpty()) {
                        System.out.print("Tem certeza? (s/n): ");
                        if (lerSim(sc)) lista.clear();
                    }
                    break;

                case 6: 
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        System.out.println("\nFim. Lista final:");
        if (lista.isEmpty()) System.out.println("Vazia.");
        else mostrar(lista);
    }

    static int lerInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Número válido: ");
            }
        }
    }

    static boolean lerSim(Scanner sc) {
        String r = sc.nextLine().trim().toLowerCase();
        return r.equals("s") || r.equals("sim");
    }

    static void mostrar(ArrayList<String> l) {
        for (int i = 0; i < l.size(); i++)
            System.out.println((i + 1) + ". " + l.get(i));
    }
}



