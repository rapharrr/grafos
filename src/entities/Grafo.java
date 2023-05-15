package entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {
    private int numVertices;
    private int numArestas;
    private int grauMinimo;
    private int grauMaximo;
    private List<List<Integer>> adjacencia;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.numArestas = 0;
        this.grauMinimo = Integer.MAX_VALUE;
        this.grauMaximo = 0;
        this.adjacencia = new ArrayList<>();

        for (int i = 0; i <= numVertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int v1, int v2) {
        adjacencia.get(v1).add(v2);
        adjacencia.get(v2).add(v1);
        numArestas++;

        int grauV1 = adjacencia.get(v1).size();
        int grauV2 = adjacencia.get(v2).size();
        grauMinimo = Math.min(grauMinimo, Math.min(grauV1, grauV2));
        grauMaximo = Math.max(grauMaximo, Math.max(grauV1, grauV2));
    }

    public void buscaLargura(int verticeInicial) {
        boolean[] visitado = new boolean[numVertices + 1];
        List<Integer> componenteConexa = new ArrayList<>();
        Queue<Integer> fila = new LinkedList<>();

        visitado[verticeInicial] = true;
        fila.offer(verticeInicial);
        componenteConexa.add(verticeInicial);

        while (!fila.isEmpty()) {
            int vertice = fila.poll();

            for (int vizinho : adjacencia.get(vertice)) {
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.offer(vizinho);
                    componenteConexa.add(vizinho);
                }
            }
        }

        System.out.println("Componente conexa encontrada: " + componenteConexa);
    }

    public void imprimirInformacoes() {
        System.out.println("Número de vértices: " + numVertices);
        System.out.println("Número de arestas: " + numArestas);
        System.out.println("Grau mínimo: " + grauMinimo);
        System.out.println("Grau máximo: " + grauMaximo);
        System.out.println("Representação do grafo:");

        for (int i = 1; i <= numVertices; i++) {
            System.out.print(i + ": ");

            for (int vizinho : adjacencia.get(i)) {
                System.out.print(vizinho + " ");
            }

            System.out.println();
        }
    }
}