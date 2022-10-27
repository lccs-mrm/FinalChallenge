import java.util.InputMismatchException;
import java.util.Scanner;

public class FinalChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantidade = 0;
        System.out.println("Por favor, informe a quantidade de números que deseja calcular");
        while (true) {
            try {
                quantidade = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe a quantidade de números que deseja calcular");
            }
        }

        Double[] numeros = new Double[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Por favor, informe os números para o cálculo da média");
            while (true) {
                try {
                    numeros[i] = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, informe os números para o cálculo da média");
                }
            }
        }

        String operacao = "";
        boolean validarOperacao = false;
        System.out.println("Por favor, escolha entre média ARITMETICA ou média HARMONICA");
        do {
            operacao = sc.next();
            switch (operacao) {
                case "ARITMETICA":
                    calculoMediaAritmetica(numeros, "ARITMETICA");
                    validarOperacao = true;
                    break;

                case "HARMONICA":
                    calculoMediaHarmonica(numeros, "HARMONICA");
                    validarOperacao = true;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, digite uma das duas médias, em uppercase e sem acento");
            }
        } while (!validarOperacao);
    }

    static void calculoMediaAritmetica(Double[] numeros, String operacao){
        double soma = 0.0;
        for (int i = 0; i < numeros.length; i++){
            soma += numeros[i];
        }
        double aritmetica = soma / numeros.length;
        printFinal(numeros, operacao, aritmetica);
    }

    private static void calculoMediaHarmonica(Double[] numeros, String operacao){
        double harmonica = 0.0;
        double soma = 0.0;
        for (int i = 0; i < numeros.length; i++){
            soma += 1 / numeros[i];
        }
        harmonica = numeros.length / soma;
        printFinal(numeros, operacao, harmonica);
    }

    private static void printFinal(Double[] numeros, String operacao, Double resultado){
        System.out.println("Você escolheu " + numeros.length + " números " + "para fazer a média " + operacao + " e o resultado dessa média é " + resultado);
    }
}
