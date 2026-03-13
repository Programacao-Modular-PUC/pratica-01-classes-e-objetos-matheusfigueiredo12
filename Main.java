import java.util.Scanner;
import java.util.Calendar;

public class Data{

    int dia, mes, ano;

    Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

class Pessoa {
    String nome, sobrenome;
    int idade;
    double altura, peso, imc;
    Data dataNascimento;

    Pessoa(String nome, String sobrenome, int idade, double altura, double peso, Data dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
    }
int calculaIdade(Data dataNascimento){

    Calendar hoje = Calendar.getInstance();

    int anoAtual = hoje.get(Calendar.YEAR);
    int mesAtual = hoje.get(Calendar.MONTH) + 1;
    int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

    int idade = anoAtual - dataNascimento.ano;

    if (mesAtual < dataNascimento.mes || 
       (mesAtual == dataNascimento.mes && diaAtual < dataNascimento.dia)) {
        idade--;
    }

    return idade;
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
        Pessoa [] pessoas = new Pessoa[10];
for(int i = 0; i < 10; i++) {

    System.out.println("\nPessoa " + (i+1));

    System.out.print("Nome: ");
    String nome = sc.next();

    System.out.print("Sobrenome: ");
    String sobrenome = sc.next();

    System.out.print("Altura: ");
    double altura = sc.nextDouble();

    System.out.print("Peso: ");
    double peso = sc.nextDouble();

    System.out.print("Dia nascimento: ");
    int dia = sc.nextInt();

    System.out.print("Mes nascimento: ");
    int mes = sc.nextInt();

    System.out.print("Ano nascimento: ");
    int ano = sc.nextInt();

    Data dataNascimento = new Data(dia, mes, ano);

    Pessoa p = new Pessoa(nome, sobrenome, 0, altura, peso, dataNascimento);

    p.idade = p.calculaIdade(dataNascimento);

    pessoas[i] = p;

    System.out.println("Idade: " + p.idade);
    System.out.println("IMC: " + p.calculaIMC());
    System.out.println("Classificação: " + p.informaObesidade());
}
    }
}
}