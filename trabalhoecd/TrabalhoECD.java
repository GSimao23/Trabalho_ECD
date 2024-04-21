
package com.mycompany.trabalhoecd;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class TrabalhoECD {

    public static void main(String[] args) {

        int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento " + (i + 1) + " do vetor:"));
        }

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu de Opções:\n" +
                            "1. Ordenação por Inserção\n" +
                            "2. Ordenação por Seleção\n" +
                            "3. Ordenação Bolha\n" +
                            "4. Sair\n" +
                            "Escolha uma opção:"));

            switch (opcao) {
                case 1:
                    ordenarPorInsercao(vetor.clone());
                    break;
                case 2:
                    ordenarPorSelecao(vetor.clone());
                    break;
                case 3:
                    ordenarPorBolha(vetor.clone());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    public static void ordenarPorInsercao(int[] vetor) {
        long inicio = System.currentTimeMillis();
        int[] original = vetor.clone();

        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = chave;
        }

        long fim = System.currentTimeMillis();
        mostrarResultado(original, vetor, fim - inicio, "Ordenação por Inserção");
    }

    public static void ordenarPorSelecao(int[] vetor) {
        long inicio = System.currentTimeMillis();
        int[] original = vetor.clone();

        for (int i = 0; i < vetor.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = vetor[indiceMenor];
            vetor[indiceMenor] = vetor[i];
            vetor[i] = temp;
        }

        long fim = System.currentTimeMillis();
        mostrarResultado(original, vetor, fim - inicio, "Ordenação por Seleção");
    }

    public static void ordenarPorBolha(int[] vetor) {
        long inicio = System.currentTimeMillis();
        int[] original = vetor.clone();

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        long fim = System.currentTimeMillis();
        mostrarResultado(original, vetor, fim - inicio, "Ordenação Bolha");
    }

    public static void mostrarResultado(int[] original, int[] ordenado, long tempo, String metodo) {
        String resultado = metodo + ":\n";
        resultado += "Vetor Original: " + Arrays.toString(original) + "\n";
        resultado += "Vetor Ordenado: " + Arrays.toString(ordenado) + "\n";
        resultado += "Tempo de execução: " + tempo + "ms";
        JOptionPane.showMessageDialog(null, resultado);
    }
}
    
//Comecei pedindo para inserir o tamanho do vetor e, em seguida, os números um por um usando caixas de diálogo para ficar melhor visualmente    .
//Depois, apresentei um menu para escolher entre três formas de organizar os números: inserção, seleção e bolha.

//Para cada forma de organização:
//Na inserção, coloquei cada número na posição correta enquanto percorria o vetor.
//Na seleção, encontrei o menor número e o troquei com o primeiro não ordenado.
//Na bolha, comparei números adjacentes e os troquei se necessário, percorrendo o vetor várias vezes.
//Depois de organizar, o programa mostrou o vetor original, o vetor organizado e o tempo que levou para fazer isso.