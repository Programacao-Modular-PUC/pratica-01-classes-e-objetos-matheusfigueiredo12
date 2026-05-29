import java.time.LocalDate;

public class Pessoa {
    // Atributos encapsulados
    private String nome;
    private String sobrenome;
    private Data dataNascimento; // Adicionado na parte 2
    private double altura;
    private double peso;
    private double imc;

    // Construtor completo
    public Pessoa(String nome, String sobrenome, Data dataNascimento, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
        this.imc = calculaIMC(); // Calcula o IMC dinamicamente na instanciação
    }

    // Método para calcular o IMC
    public double calculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
        return this.imc;
    }

    // Método para calcular a idade com base na data de nascimento
    public int calculaIdade() {
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - dataNascimento.getAno();
        
        // Ajuste caso o aniversário ainda não tenha ocorrido no ano corrente
        if (dataAtual.getMonthValue() < dataNascimento.getMes() || 
           (dataAtual.getMonthValue() == dataNascimento.getMes() && dataAtual.getDayOfMonth() < dataNascimento.getDia())) {
            idade--;
        }
        return i;
    }

    // Método para classificar o IMC conforme a tabela fornecida
    public String informaObesidade() {
        if (this.imc < 18.5) return "Abaixo do peso";
        if (this.imc < 25.0) return "Peso normal";
        if (this.imc < 30.0) return "Sobrepeso";
        if (this.imc < 35.0) return "Obesidade grau 1";
        if (this.imc < 40.0) return "Obesidade grau 2";
        return "Obesidade grau 3";
    }

    // Retorna o nome formatado: Sobrenome Nome, PRIMEIRO_NOME_MAIÚSCULO
    public String getNomeReferencia() {
        return this.sobrenome + ", " + this.nome.toUpperCase();
    }

    // Getters e Setters
    public String getNomeCompleto() { return this.nome + " " + this.sobrenome; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public Data getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Data dataNascimento) { this.dataNascimento = dataNascimento; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public double getImc() { return imc; }
}