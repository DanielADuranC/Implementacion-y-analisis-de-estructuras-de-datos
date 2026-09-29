package List;


import java.util.function.IntConsumer;


public class main {

    public static long exec(int size, String method, IntConsumer operation) {
        long start = System.nanoTime(); 
        
        for (int i =0; i<size; i++)
            operation.accept(i);

        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        return timeElapsed;
    }

    public static void main(String[] args) {
        final int start = 100;
        final int end = 10000;

        for (int size = start; size <= end; size *= 10){
            System.out.println("Tamaño de la lista: " + size);
            long promTime = 0;
            for (int i =0; i<3; i++){
                SingleList<Integer> warmup = new SingleList<>();
                for (int j = 0; j < 100000; j++) {
                    warmup.pushFront(j);
                }
                SingleList<Integer> lista = new SingleList<>();
                promTime += exec(size, "pushFront", (e) -> lista.pushFront(e));
            }
            promTime = promTime / 3;
            System.out.printf("Tiempo promedio de pushFront en SingleList: %d nanosegundos\n", promTime / 3);
        }
    }
}