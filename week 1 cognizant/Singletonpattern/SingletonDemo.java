public class SingletonDemo {

    static class Singleton {
        private Singleton() {
        }

        private static class SingletonHelper {
            private static final Singleton INSTANCE = new Singleton();
        }

        public static Singleton getInstance() {
            return SingletonHelper.INSTANCE;
        }

        public void showMessage() {
            System.out.println("Hello from Singleton!");
        }
    }

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        obj1.showMessage();

        if (obj1 == obj2) {
            System.out.println("Both objects are the same instance.");
        } else {
            System.out.println("Different instances created.");
        }
    }
}

