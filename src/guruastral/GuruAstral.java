package guruastral;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Random;

public class GuruAstral {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        // Obtendo a data atual do sistema
        Calendar hoje = Calendar.getInstance();

        int diaAtual = hoje.get(Calendar.DATE);
        int mesAtual = hoje.get(Calendar.MONTH) + 1; // Mês começa em zero, então adicionamos 1
        int anoAtual = hoje.get(Calendar.YEAR);

        // Obtendo os dados do usuário
        System.out.println("Digite seu nome completo: ");
        String nome = ler.nextLine();
        if (nome.length() >= 8) {
            System.out.println("Olá, " + nome + "!");
        } else if (nome.length() < 8) {
            System.out.println("Legal se o seu nome fosse verdadeiro!");
            System.exit(1);
        }

        System.out.println("Digite seu sexo (1 para feminino, 2 para masculino):");
        int opcao = ler.nextInt();
        String sexo;
        if (opcao == 1) {
            sexo = "Feminino";
        } else {
            sexo = "Masculino";
        }

        System.out.println("Digite o dia do seu nascimento:");
        int diaNasc = ler.nextInt();
        if (diaNasc < 1 || diaNasc > 31) {
            System.out.println("Dia inválido!");
            System.exit(1);
        }

        System.out.println("Digite o mês do seu nascimento:");
        int mesNasc = ler.nextInt();
        if (mesNasc < 1 || mesNasc > 12) {
            System.out.println("Mês inválido!");
            System.exit(1);
        }

        System.out.println("Digite o ano do seu nascimento:");
        int anoNasc = ler.nextInt();
        if (anoNasc < 1900 || anoNasc > anoAtual) {
            System.out.println("Ano inválido!");
            System.exit(1);
        }

        int anos = anoAtual - anoNasc;
        if (mesAtual < mesNasc || (mesAtual == mesNasc && diaAtual < diaNasc)) {
            anos--; // Ainda não completou o aniversário deste ano
        }

        // Verificando o signo da pessoa
        String signo = verifSigno(diaNasc, mesNasc);

        // Gerando o numero da sorte
        int sorte = sortearNumeroSorte();
        
   
        // Gerando mensagem personalizada
verificar(mesNasc, diaNasc);
        if (opcao == 1) {
            System.out.println("Sra." + nome + ", nascida no dia " + diaNasc + "/" + mesNasc + "/" + anoNasc + " é do signo de " + signo + " , você tem " + anos + " anos o seu nº da sorte é " + sorte + " sua cor da sorte é "+gerarCor()+" e a criptomoeda que vai te deixar rico é "+gerarCripto());
        } else {
            System.out.println("Sr." + nome + ", nascido no dia " + diaNasc + "/" + mesNasc + "/" + anoNasc + " é do signo de " + signo + " , você tem " + anos + " anos , seu nº da sorte é " + sorte + " sua cor da sorte é " +gerarCor()+" e a criptomoeda que vai te deixar rico é "+gerarCripto());
        }
    }

    // Método para verificar o signo da pessoa
    public static String verifSigno(int diaNasc, int mesNasc) {
        String signo = "";
        String a[] = {"Aquário", "Peixes", "Áries", "Touro", "Gêmeos", "Câncer", "Leão",
            "Virgem", "Libra", "Escorpião", "Sagitário", "Capricórnio"};
        if (mesNasc == 1 && diaNasc >= 21 || mesNasc == 2 && diaNasc <= 19) {
            signo = a[0];
        } else if (mesNasc == 2 && diaNasc >= 20 && diaNasc <= 28 || mesNasc == 3 && diaNasc <= 20) {
            signo = a[1];
        } else if (mesNasc == 3 && diaNasc >= 21 || mesNasc == 4 && diaNasc <= 20) {
            signo = a[2];
        } else if (mesNasc == 4 && diaNasc >= 21 && diaNasc <=31|| mesNasc == 5 && diaNasc <= 20) {
            signo = a[3];
        } else if (mesNasc == 5 && diaNasc >= 21 || mesNasc == 6 && diaNasc <= 20) {
            signo = a[4];
        } else if (mesNasc == 6 && diaNasc >= 21 && diaNasc <= 30 || mesNasc == 7 && diaNasc <= 21) {
            signo = a[5];
        } else if (mesNasc == 7 && diaNasc >= 22 || mesNasc == 8 && diaNasc <= 22) {
            signo = a[6];
        } else if (mesNasc == 8 && diaNasc >= 23 || mesNasc == 9 && diaNasc <= 22) {
            signo = a[7];
        } else if (mesNasc == 9 && diaNasc >= 23 && diaNasc <= 30 || mesNasc == 10 && diaNasc <= 22) {
            signo = a[8];
        } else if (mesNasc == 10 && diaNasc >= 23 || mesNasc == 11 && diaNasc <= 21) {
            signo = a[9];
        } else if (mesNasc == 11 && diaNasc >= 22 && diaNasc <= 30 || mesNasc == 12 && diaNasc <= 21) {
            signo = a[10];
        } else if (mesNasc == 12 && diaNasc >= 22 || mesNasc == 1 && diaNasc <= 20) {
            signo = a[11];
        }
        return signo;
    }

    // Método para sortear um número de sorte
    public static int sortearNumeroSorte() {
        return (int) (1 + Math.random() * 100);
    }

    public static String gerarCor() {
        String[] cor = {"vermelho", "azul", "lilás", "rosa ", " verde ", " amarelo"};
        Random nCor = new Random();
        int vet = cor.length;
        int i = nCor.nextInt(vet);
        String cores = cor[i];
        return cores;
    }
    public static String gerarCripto(){
        String [] cripto = {"bitcoin #GO TO THE MOON", "ethereum GO TO THE MOON","Dogecoin GO TO THE MOON"};
        Random nCripto = new Random();
        int vet = cripto.length;
        int i = nCripto.nextInt(vet);
        String criptos = cripto[i];
        return criptos;
    }
    public static int verificar(int mesNasc, int diaNasc){
          if ((mesNasc == 2 && diaNasc > 28) || 
        (mesNasc == 4 || mesNasc == 6 || mesNasc == 9 || mesNasc == 11) && diaNasc > 30) {
        System.out.println("Data inválida! Insira uma data correta!");
        System.exit(diaNasc);

          }
            return mesNasc;
    }
}