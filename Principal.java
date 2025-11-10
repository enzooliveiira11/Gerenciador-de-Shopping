import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;

        int opcao;
        do {
            System.out.println("\nMENU PRINCIPAL:");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                sc.next();
            }
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome da loja: ");
                    String nomeLoja = sc.nextLine();

                    int qtdFunc;
                    do {
                        System.out.print("Quantidade de funcionários: ");
                        while (!sc.hasNextInt()) {
                            System.out.println("Valor inválido. Digite um número inteiro.");
                            sc.next();
                        }
                        qtdFunc = sc.nextInt();
                    } while (qtdFunc < 0);

                    double salarioBase;
                    do {
                        System.out.print("Salário base dos funcionários: ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Valor inválido. Digite um número decimal.");
                            sc.next();
                        }
                        salarioBase = sc.nextDouble();
                    } while (salarioBase < 0);

                    sc.nextLine();
                    System.out.print("Nome da rua: ");
                    String rua = sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();
                    System.out.print("País: ");
                    String pais = sc.nextLine();
                    System.out.print("CEP: ");
                    String cep = sc.nextLine();
                    System.out.print("Número: ");
                    String numero = sc.nextLine();
                    System.out.print("Complemento: ");
                    String complemento = sc.nextLine();
                    Endereco endereco = new Endereco(rua, cidade, estado, pais, cep, numero, complemento);

                    int dia, mes, ano;
                    System.out.print("Dia da fundação: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    dia = sc.nextInt();
                    System.out.print("Mês da fundação: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    mes = sc.nextInt();
                    System.out.print("Ano da fundação: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    ano = sc.nextInt();
                    sc.nextLine();
                    Data fundacao = new Data(dia, mes, ano);

                    int qtdMaxProdutos;
                    System.out.print("Quantidade máxima de produtos: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    qtdMaxProdutos = sc.nextInt();
                    sc.nextLine();

                    loja = new Loja(nomeLoja, qtdFunc, salarioBase, endereco, fundacao, qtdMaxProdutos);
                    System.out.println("\nLoja criada com sucesso!\n" + loja);
                    break;

                case 2:
                    System.out.print("Nome do produto: ");
                    String nomeProd = sc.nextLine();

                    double preco;
                    System.out.print("Preço do produto: ");
                    while (!sc.hasNextDouble()) { sc.next(); }
                    preco = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Dia da validade: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    int diaVal = sc.nextInt();
                    System.out.print("Mês da validade: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    int mesVal = sc.nextInt();
                    System.out.print("Ano da validade: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    int anoVal = sc.nextInt();
                    sc.nextLine();

                    Data validade = new Data(diaVal, mesVal, anoVal);
                    produto = new Produto(nomeProd, preco, validade);

                    if (produto.estaVencido(new Data(20, 10, 2023))) {
                        System.out.println("PRODUTO VENCIDO");
                    } else {
                        System.out.println("PRODUTO NÃO VENCIDO");
                    }

                    if (loja != null) {
                        boolean inserido = loja.insereProduto(produto);
                        System.out.println(inserido ? "Produto inserido na loja." : "Não foi possível inserir o produto.");
                    }
                    break;

                case 3:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 3);

        sc.close();
    }
}