public class tower {

    // pivot'ы - стержни
    // part - в начале количество колец в башне, при выполнении программы кольцо, с которым программа работает в данный момент
    // step - номер хода

    public static int step = 1;
    static void print_move(int step, int part, String start_pivot, String finish_pivot) {
        System.out.printf("Шаг %d: переместить кольцо %d из стержня %s на стержень %s", step, part, start_pivot, finish_pivot);
        System.out.println();
        tower.step++;
    } 

    static void transp(int part, String pivot_a, String pivot_b, String pivot_c) {
        if(part == 1) {
            print_move(step, part, pivot_a, pivot_c);
            return;
        } else {
            transp(part-1, pivot_a, pivot_c, pivot_b);
            print_move(step, part, pivot_a, pivot_c);
            transp(part-1, pivot_b, pivot_a, pivot_c);
        }
    }
    public static void main(String[] args){
        int part = 5;
        String pivot_a = "A";
        String pivot_b = "B";
        String pivot_c = "C";
        System.out.printf("Порядок действий для переноса %d элементов в ханойской башне из стержня А в стержень С.", part);
        System.out.println();
        transp(part, pivot_a, pivot_b, pivot_c);

    }
}
