class Bicho {

    private String nome;
    private int fome;        // 0 = satisfeito, 100 = faminto
    private int felicidade;  // 0 = triste, 100 = muito feliz

    public Bicho(String nome) {
        this.nome = nome;
        this.fome = 50;
        this.felicidade = 50;
    }

    public String getNome() {
        return nome;
    }

    public int getFome() {
        return fome;
    }

    public boolean estaVivo() {
        return fome < 100;
    }

    // Mantém os valores sempre entre 0 e 100
    private int limitar(int valor) {
        if (valor < 0) {
            return 0;
        }
        if (valor > 100) {
            return 100;
        }
        return valor;
    }

    public void alimentar(String comida, int reducaoFome, int ganhoFelicidade) {
        if (fome <= 10) {
            System.out.println(nome + " não está com fome e recusou a comida.");
            felicidade = limitar(felicidade - 10);
            return;
        }

        fome = limitar(fome - reducaoFome);
        felicidade = limitar(felicidade + ganhoFelicidade);
        System.out.println(nome + " comeu " + comida + "!");
    }

    // O tempo passa e o bichinho fica com mais fome
    public void passarTempo() {
        fome = limitar(fome + 20);
        felicidade = limitar(felicidade - 10);
        System.out.println("O tempo passou...");
    }

    public String humor() {
        if (fome >= 80) {
            return "faminto";
        }
        if (felicidade >= 70) {
            return "muito feliz";
        }
        if (felicidade >= 40) {
            return "tranquilo";
        }
        return "triste";
    }

    public void mostrarStatus() {
        System.out.println("\n--- Status de " + nome + " ---");
        System.out.println("Fome: " + fome + "/100");
        System.out.println("Felicidade: " + felicidade + "/100");
        System.out.println("Humor: " + humor());
        System.out.println("---------------------------");
    }
}