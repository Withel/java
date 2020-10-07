package sample;

class SemaphoresTest {
    private static final int COUNT = 30; //ile liter wyswietlaja watki
    private static final int DELAY = 5; //opóznienie czasowe pozwalajace uzyskac wieksze przemieszanie liter przy szybkich procesorach

    public static void main(String[] args) {
        new A().start(); //uruchomienie watku o nazwie A zdefiniowanego ponizej
        new B().start();
        new C().start();
    }

    //deklaracja watku
//watek wypisuje na ekran(konsole) litere A tyle razy ile wynosi wartosc zmiennej COUNT
//po kazdym wypisaniu czeka(usypia sie) tyle milisekund ile wynosi wartosc zmiennej DELAY
//opóznienie zastosowano w celu uzyskania wiekszego przemieszania liter wyswietlanych przez wszystkie watki
    private static final class A extends Thread {
        @Override
        @SuppressWarnings("SleepWhileInLoop")
        public void run() {
            try {
                for (int i = 0; i < COUNT; i++) {
                    System.out.print("A ");
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException ex) {
            }
        }
    }

    private static final class B extends Thread {
        @Override
        @SuppressWarnings("SleepWhileInLoop")

        public void run() {
            try {
                for (int i = 0; i < COUNT; i++) {
                    System.out.print("B ");
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException ex) {
            }
        }
    }

    private static final class C extends Thread {
        @Override
        @SuppressWarnings("SleepWhileInLoop")
        public void run() {
            try {
                for (int i = 0; i < COUNT; i++) {
                    System.out.print("C ");
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
