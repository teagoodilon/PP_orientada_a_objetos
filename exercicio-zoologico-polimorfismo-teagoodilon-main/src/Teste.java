public class Teste {
    public static void main(String[] args) throws Exception {
        Animal animal = new Lobo("josue", "cinza");
        System.out.println(animal.getNome());
        animal = new Galinha("josefa");
        System.out.println(animal.getNome());
        animal = new Lobo("clayton", "laranja");
        System.out.println(animal.getDescLonga());
        animal = new Galinha("lilica");
        System.out.println(animal.getDescLonga());
    }
}
