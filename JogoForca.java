import java.util.Scanner;
import java.util.Random;

public class JogoForca {
    public static void main (String[] args) {
        System.out.println("===============");
        System.out.println(" Jogo da Forca ");
        System.out.println("===============");
        Scanner in = new Scanner(System.in);

        // Configurar jogo
        String[] bancoPalavras = {
            "ABACATE",
            "MANGA",
            "MELANCIA",
            "JABUTICABA",
            "BANANA",
            "PESSEGO",
        };

        Random rnd = new Random();

        int indicePalavraSorteada = rnd.nextInt(bancoPalavras.length);
        int chancesRestantes = 10;
        String palavraSorteada = bancoPalavras[indicePalavraSorteada];
        int tamPalavraSorteada = palavraSorteada.length();
        char[] letrasEscondidas = palavraSorteada.toCharArray();
        char[] letrasReveladas = new char[tamPalavraSorteada];
        for (int i = 0; i < tamPalavraSorteada; i++) {
            letrasReveladas[i] = '?';
        }
        boolean achou = false;


		// Loop do jogo
        while (chancesRestantes > 0 && !achou) {
            System.out.println("\nChances restantes: " + chancesRestantes);
            
            // Mostra letras ja reveladas
            for (int i = 0; i < tamPalavraSorteada; i++) {
                System.out.print(letrasReveladas[i]);
            }
            System.out.println(); // quebra a linha

            // Solicita letra do usuario
            System.out.print("Letra: ");
            String strLetraDigitada = in.nextLine().toUpperCase();
            char letraDigitada = strLetraDigitada.charAt(0);

            // Revela letras, se existirem.
            boolean letraEncontrada = false;
            achou = true;
            for (int i = 0; i < tamPalavraSorteada; i++) {
                if (letrasEscondidas[i] == letraDigitada) {
                    letraEncontrada = true;
                    letrasReveladas[i] = letrasEscondidas[i];
                }
                if (letrasReveladas[i] == '?') {
                    achou = false;
                }
            }
            
			// Reduz nro de chances se letra digitada nao existir.
            if (!letraEncontrada) {
                chancesRestantes--;
            }
        }

        if(achou) {
            System.out.println("========================");
            System.out.println(" Parabéns, você Ganhou! ");
            System.out.println("========================");
        }
        else {
            System.out.println(palavraSorteada); // Revela a palavra
            System.out.println(); // quebra a linha

            System.out.println("========================");
            System.out.println(" Que pena, você Perdeu! ");
            System.out.println("========================");
        }
        System.out.println("===========");
        System.out.println(" Game Over ");
        System.out.println("===========");

    }



}