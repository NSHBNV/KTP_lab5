import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    //константа с максимальным количеством итераций
    public static final int MAX_ITERATIONS = 2000;

    //метод для определения области для конкретного фрактала
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    //метод реализации функции для фрактала Мандельброта
    public int numIterations(double x, double y) {
        /** Итератор*/
        int iteration = 0;
        /** Инициализируем мнимую и реальную части */
        double zreal = 0;
        double zimaginary = 0;

        while (iteration < MAX_ITERATIONS &&
                zreal * zreal + zimaginary * zimaginary < 4) {
            double zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
            double zimaginaryUpdated = 2 * zreal * zimaginary + y;
            zreal = zrealUpdated;
            zimaginary = zimaginaryUpdated;
            iteration += 1;
        }

        /**
         * Если количество максимальных итераций достигнуто, возвращаем -1, чтобы
         * указать, что точка не вышла за границу.
         */
        if (iteration == MAX_ITERATIONS) {
            return -1;
        }

        return iteration;
    }
    //метод, который возвращает имя фрактала
    public String toString() {
        return "Mandelbrot";
    }
}
