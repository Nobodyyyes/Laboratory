package algorithmDes;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class AlgorithmDes {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сообщение: ");
        String message = scanner.nextLine();
        System.out.println("Начальное сообщение: " + message);

        // Генерация ключа DES
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56); // Длина ключа 56 бит
        SecretKey secretKey = keyGenerator.generateKey();

        // Шифрование
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());

        // Декодирование зашифрованного сообщения в Base64 для удобного отображения
        String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessage);
        System.out.println("Зашифрованное сообщение: " + encodedMessage);

        // Дешифрование
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedMessage = cipher.doFinal(Base64.getDecoder().decode(encodedMessage));

        System.out.println("Расшифрованное сообщение: " + new String(decryptedMessage));
    }
}
