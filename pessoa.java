import java.util.Scanner;

class Pessoa {
    String nome, sobrenome;
    int idade;
    double altura, peso, imc;

    Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    double calculaIMC() {
        imc = peso / (altura * altura);
        return imc;
    }

    String informaObesidade() {
        if (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25) return "Peso normal";
        else if (imc < 30) return "Sobrepeso";
        else if (imc < 35) return "Obesidade grau 1";
        else if (imc < 40) return "Obesidade grau 2";
        else return "Obesidade grau 3";
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.print("Altura: ");
        double altura = sc.nextDouble();

        System.out.print("Peso: ");
        double peso = sc.nextDouble();

        Pessoa p = new Pessoa(nome, sobrenome, idade, altura, peso);

        System.out.println("IMC: " + p.calculaIMC());
        System.out.println("Classificação: " + p.informaObesidade());
    }
}