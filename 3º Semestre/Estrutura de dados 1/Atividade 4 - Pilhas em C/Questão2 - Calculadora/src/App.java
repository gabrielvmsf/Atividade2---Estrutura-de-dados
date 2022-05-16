import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Qual tipo de notação a expressão estará sendo inserida na calculadora \n1.infixa\n2.pós-fixa\n3.pré-fixa)\n");
        int notacao = scan.nextInt();
        Calculadora c = new Calculadora();
        Operadores o = new Operadores();
        int qtd;
        int k = 0, j = 0;

        while (true) {

            System.out.println("O proximo valor será\n1.número\n2.operador\n3.Calcular");
            int v = scan.nextInt();

            if (v == 1) {
                System.out.println("Digite o valor:");
                float valor = scan.nextFloat();
                c.push(valor);
                k++;

            } else if (v == 2) {
                System.out.println("Digite o operador:");
                String op = scan.next();
                o.push(op);
                j++;
            } else {
                if (k > 1 && j > 0) {
                    c.setQtd(k);
                    o.setQtd(j);
                    o.push(" ");
                    qtd = j + k;
                    break;
                } else
                    System.out.println("Não foram digitados operadores/valores suficientes");
            }
        }
        float valor1, valor2, junção,num[];
        String op[], operand;
        num = new float[k];
        op = new String[j];
        for(int i = 0; i<k; i++){
            num[i] = c.elementos[i];
        }
        for(int i = 0; i<k; i++){
            op[i] = o.elementos[i];
        }

        if (notacao == 1) {

            for (int i = 0; i < c.getQtd(); i++) {
                if (c.top != 0) {
                    
                    System.out.print(num[i]);
                    System.out.print(op[i]);

                    valor1 = c.pop();
                    valor2 = c.pop();
                    operand = o.pop();
                    if (operand.compareTo("+") == 0) {
                        junção = valor1 + valor2;
                        c.push(junção);
                        c.setQtd(c.getQtd() + 1);
                        c.resultado = junção;
                    } else if (operand.compareTo("-") == 0) {
                        junção = valor2 - valor1;
                        c.push(junção);
                        c.setQtd(c.getQtd() + 1);
                        c.resultado = junção;
                    } else if (operand.compareTo("*") == 0) {
                        junção = valor1 * valor2;
                        c.push(junção);
                        c.setQtd(c.getQtd() + 1);
                        c.resultado = junção;
                    } else if (operand.compareTo("/") == 0) {
                        junção = valor2 / valor1;
                        c.push(junção);
                        c.setQtd(c.getQtd() + 1);
                        c.resultado = junção;
                    }
                }
            }
        }
        System.out.println("Resultado da conta: " + c.resultado);
    }

}
