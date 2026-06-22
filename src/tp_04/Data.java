/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_04;

/**
 *
 *  Nomes: João Victor Lima Venceslau - Rayssa Silva de Oliveira
 */
/**
 * Crie a classe Data conforme especificado abaixo:
┌─────────────────────────────────┐
│              Data               │
├─────────────────────────────────┤
│ - dia: int                      │
│ - mes: int                      │
│ - ano: int                      │
├─────────────────────────────────┤
│ + Data()                        │
│ + Data(int d, int m, int a)     │
│ + entraDia(int d)               │
│ + entraMes(int m)               │
│ + entraAno(int a)               │
│ + entraDia()                    │
│ + entraMes()                    │
│ + entraAno()                    │
│ + retDia(): int                 │
│ + retMes(): int                 │
│ + retAno(): int                 │
│ + mostra1(): String             │
│ + mostra2(): String             │
│ + bissexto(): boolean           │
│ + diasTranscorridos(): int      │
│ + apresentaDataAtual(): void    │
└───────────────────────────────────┘
 * • O construtor Data() deverá permitir ao usuário digitar os valores de dia, mês e ano e com eles
inicializar os atributos da classe. Os valores digitados deverão ser consistidos e só aceitos se válidos,
caso contrário, redigitar;
• O construtor Data(int d, int m, int a) deverá receber os valores de dia, mês e ano e com eles inicializar
as propriedades da classe;
• Os métodos entraDia(int d), entraMes(int m) e entraAno(int a) devem receber um valor e atribuí-lo às
respectivas propriedades;

• Os métodos entraDia (),entraMes () e entraAno () devem permitir ao usuário digitar um valor e atribuí-
lo a respectiva propriedade. Os valores digitados devem sofrer consistência e só aceitos quando válidos,

caso contrário, solicitar ao usuário redigitar;
• Os métodos retDia(), retMes() e retAno() devem nos devolver as respectivas propriedades;
• O método mostra1() deve nos devolver a data no formato: dd/mm/aaaa;
• O método mostra2() deve nos devolver a data no formato: dd/mesPorExtenso/ano;
• O método bissexto() deve nos devolver um boolean informando se o ano é ou não bissexto;
• O método diasTranscorridos, deve retornar a quantidade de dias transcorridos no ano até a data
digitada.
• O método apresentaDataAtual() deve imprimir a data atual, utilizando as classes Date e DateFormat, o
DateFormat empregando o seguinte método: getDateInstance(DateFormat.FULL);
• Conveniente colocar tratamento de exceção para as possíveis inconsistências na entrada de dados.
 */

import java.util.*;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        Scanner sc = new Scanner(System.in);
        
        int a;
        while (true) {
            System.out.print("Digite o ano: ");
            a = sc.nextInt();
            if (a >= 0) break;
            System.out.println("Ano invalido.");
        }
        this.ano = a;

        int m;
        while (true) {
            System.out.print("Digite o mes: ");
            m = sc.nextInt();
            if (m >= 1 && m <= 12) break;
            System.out.println("Mes invalido.");
        }
        this.mes = m;

        int d;
        while (true) {
            System.out.print("Digite o dia: ");
            d = sc.nextInt();
            if (validarDia(d, this.mes, this.ano)) break;
            System.out.println("Dia invalido para este mes/ano.");
        }
        this.dia = d;
    }

    public Data(int d, int m, int a) {
        if (a >= 0) this.ano = a;
        if (m >= 1 && m <= 12) this.mes = m;
        if (validarDia(d, this.mes, this.ano)) this.dia = d;
    }

    public void entraDia(int d) {
        if (validarDia(d, this.mes, this.ano)) this.dia = d;
    }

    public void entraMes(int m) {
        if (m >= 1 && m <= 12) {
            this.mes = m;
            if (!validarDia(this.dia, this.mes, this.ano)) {
                this.dia = 1;
            }
        }
    }

    public void entraAno(int a) {
        if (a >= 0) {
            this.ano = a;
            if (!validarDia(this.dia, this.mes, this.ano)) {
                this.dia = 1;
            }
        }
    }

    public void entraDia() {
        Scanner sc = new Scanner(System.in);
        int d;
        while (true) {
            System.out.print("Digite o dia: ");
            d = sc.nextInt();
            if (validarDia(d, this.mes, this.ano)) break;
            System.out.println("Dia invalido.");
        }
        this.dia = d;
    }

    public void entraMes() {
        Scanner sc = new Scanner(System.in);
        int m;
        while (true) {
            System.out.print("Digite o mes: ");
            m = sc.nextInt();
            if (m >= 1 && m <= 12) break;
            System.out.println("Mes invalido.");
        }
        this.mes = m;
        if (!validarDia(this.dia, this.mes, this.ano)) {
            this.dia = 1;
        }
    }

    public void entraAno() {
        Scanner sc = new Scanner(System.in);
        int a;
        while (true) {
            System.out.print("Digite o ano: ");
            a = sc.nextInt();
            if (a >= 0) break;
            System.out.println("Ano invalido.");
        }
        this.ano = a;
        if (!validarDia(this.dia, this.mes, this.ano)) {
            this.dia = 1;
        }
    }

    public int retDia() { return this.dia; }
    public int retMes() { return this.mes; }
    public int retAno() { return this.ano; }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", 
                          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", this.dia, meses[this.mes - 1], this.ano);
    }

    public boolean bissexto() {
        return (this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (bissexto()) diasMes[1] = 29;
        
        int total = 0;
        for (int i = 0; i < this.mes - 1; i++) {
            total += diasMes[i];
        }
        total += this.dia;
        return total;
    }

    public void apresentaDataAtual() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df.format(new Date()));
    }

    private boolean validarDia(int d, int m, int a) {
        if (m < 1 || m > 12) return false;
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) diasMes[1] = 29;
        return d >= 1 && d <= diasMes[m - 1];
    }
}
