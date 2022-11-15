public class Peludo extends Animal {
    private String corPelo;

    public Peludo(String nome, String especie, String som, String corPelo){
        super(nome, especie, som, 4);
        this.corPelo = corPelo;
    }

    public String getPelo() {
        return corPelo;
    }

    public String getDescLonga() {
        String desc = super.getDescLonga() + " e tem pelo " + getPelo();
        return desc;
    }

}
