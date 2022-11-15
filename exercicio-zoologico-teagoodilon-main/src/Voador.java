public class Voador extends Animal {
    private boolean voaBem;

    public Voador(String nome, String especie, String som, boolean voaBem){
        super(nome, especie, som, 2);
        this.voaBem = voaBem;
    }

    public boolean getVoaBem() {
        return voaBem;
    }

    public String getDescLonga() {
        String desc = super.getDescLonga() + " e voa ";
        if (getVoaBem()) {
            return desc + "bem";
        } else {
            return desc + "mal";
        }
    }
}
