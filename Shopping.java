class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int qtdMaxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[qtdMaxLojas];
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public Loja[] getLojas() { return lojas; }
    public void setLojas(Loja[] lojas) { this.lojas = lojas; }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int contador = 0;
        for (Loja loja : lojas) {
            if (loja == null) continue;
                switch (tipoLoja.toLowerCase()) {
                    case "cosmetico":
                    case "cosmético":
                        if (loja instanceof Cosmetico) contador++;
                        break;
                    case "vestuario":
                    case "vestuário":
                        if (loja instanceof Vestuario) contador++;
                        break;
                    case "bijuteria":
                        if (loja instanceof Bijuteria) contador++;
                        break;
                    case "alimentacao":
                    case "alimentação":
                        if (loja instanceof Alimentacao) contador++;
                        break;
                    case "informatica":
                    case "informática":
                        if (loja instanceof Informatica) contador++;
                        break;
                    default:
                        return -1;
                }
        }
        return contador;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCara = null;
        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica info = (Informatica) loja;
                if (maisCara == null || info.getSeguroEletronicos() > maisCara.getSeguroEletronicos()) {
                    maisCara = info;
                }
            }
        }
        return maisCara;
    }

    @Override
    public String toString() {
        return "Shopping: " + nome + "\nEndereco: " + endereco + "\nCapacidade de lojas: " + lojas.length;
    }
}
