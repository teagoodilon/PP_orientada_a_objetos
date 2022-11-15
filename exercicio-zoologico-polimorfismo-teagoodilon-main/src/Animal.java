public class Animal extends Zoologico{
    private String nome;
    private String especie;
    private String som;
    private int qtdPatas;

    public Animal(String nome, String especie, String som, int qtdPatas) {
        this.nome = nome;
        this.especie = especie;
        this.som = som;
        this.qtdPatas = qtdPatas;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getSom() {
        return som;
    }

    public int getQtdPatas() {
        return qtdPatas;
    }

    public String getDescricao() {
        String desc = getNome() + " é um " + getEspecie();
        return desc;
    }

    public String getDescLonga() {
        String desc = getDescricao() + " que faz " + getSom();
        return desc;
    }
    
}
