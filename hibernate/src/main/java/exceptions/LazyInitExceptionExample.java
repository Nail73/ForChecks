package exceptions;

public class LazyInitExceptionExample {
    private static String uninitializedString;

    public static void main(String[] args) {
        try {
            // Попытка получить значение неинициализированной переменной
            String value = getUninitializedString();
            System.out.println("Value: " + value);
        } catch (LazyInitException e) {
            System.out.println("Caught exception: " + e);
        }
    }

    public static String getUninitializedString() throws LazyInitException {
        if (uninitializedString == null) {
            // Если переменная не инициализирована, выбрасываем исключение
            throw new LazyInitException("Uninitialized string");
        }
        return uninitializedString;
    }

    private static class LazyInitException extends Exception {
        public LazyInitException(String message) {
            super(message);
        }
    }
}