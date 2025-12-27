public class Encrypt_Message{

    private String message;
    private int shift;
    private String encryptedMessage;

    // Constructor
    public Encrypt_Message(String message, int shift) {
        this.message = message;
        this.shift = shift % 26;  // عشان نضمن ان قيمه ال shift تبقي بين 0-25
        this.encryptedMessage = encrypt();
    }

    // Set message
    public void setMessage(String message) {
        this.message = message;
        this.encryptedMessage = encrypt();
    }

    // Encrypt (internal use only)
    private String encrypt() {
        StringBuilder encrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int shifted = (c - base + shift) % 26;
                encrypted.append((char) (base + shifted));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    // Decrypt (available for user)
    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();

        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int shifted = (c - base - shift + 26) % 26;
                decrypted.append((char) (base + shifted));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }

    // Getter for encrypted message
    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    // Print original & encrypted message
    public void printBoth() {
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
    }

    // Main method
    public static void main(String[] args) {
        Encrypt_Message em =
                new Encrypt_Message("the best programmer is mazen", 3);

        em.printBoth();
    }
}
