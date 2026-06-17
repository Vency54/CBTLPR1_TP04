/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_04;

/**
 *
 *  Nomes: João Victor Lima Venceslau - Rayssa Silva de Oliveira.
 */
/**Exercício 02
Agora, desenvolva um programa capaz de testar a classe e os métodos desenvolvidos no
exercício anterior.*/

public class CBTLPR1_TP04 {
    public static void main(String[] args) {
        System.out.println("Teste Construtor Padrao:");
        Data d1 = new Data();
        System.out.println("Data 1 (mostra1): " + d1.mostra1());
        System.out.println("Data 1 (mostra2): " + d1.mostra2());
        System.out.println("Bissexto: " + d1.bissexto());
        System.out.println("Dias transcorridos: " + d1.diasTranscorridos());
        
        System.out.println("\nTeste Construtor com Parametros (15/06/2024):");
        Data d2 = new Data(15, 6, 2024);
        System.out.println("Data 2: " + d2.mostra1());
        
        System.out.println("\nAlterando Data 2 via teclado:");
        d2.entraAno();
        d2.entraMes();
        d2.entraDia();
        System.out.println("Nova Data 2: " + d2.mostra2());
        
        System.out.println("\nData Atual do Sistema:");
        d2.apresentaDataAtual();
    }
}
