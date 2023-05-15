/*Nomes:
Raphael Bispo Elias RGM: 26138051
Alisson Gustavo Perciliano Pedrosa RGM: 26773759 
Paulo Renato Veloso Junior RGM:25586157
Eduardo Benedito Caitano dos Santos, Rgm:26577011
*/


package application;
import java.util.Scanner;

import entities.Grafo;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de vértices do grafo: ");
        int numVertices = scanner.nextInt();
        Grafo grafo = new Grafo(numVertices);

        System.out.print("Digite o número de arestas do grafo: ");
        int numArestas = scanner.nextInt();

        System.out.println("Digite as arestas do grafo:");
        for (int i = 0; i < numArestas; i++) {
            System.out.print("Aresta " + (i + 1) + ": ");
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            grafo.adicionarAresta(v1, v2);
        }

        System.out.println();

        grafo.imprimirInformacoes();

        System.out.print("Digite o vértice inicial para busca em largura: ");
        int verticeInicial = scanner.nextInt(); 
        grafo.buscaLargura(verticeInicial);

        scanner.close();
    }
}