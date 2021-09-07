package ru.job4j.ood.tictactoe;


public class Play {
    private MatrixInterface matrix;
    private QueueInterface queue;

    public Play(MatrixInterface matrix,  QueueInterface queue) {
        this.matrix = matrix;
        this.queue = queue;
    }

    public void start(LogicInterface logic, Input input, Output out) {
        int temp = 0;
        new CreateMatrix().newPole(matrix);
        Input validateInput = new ValidateInput(new ConsoleOutput(), new ConsoleInput(), matrix);
        while (!logic.isGameEnd()) {
            queue.nextPlayer();
            out.println("\nХод игрока " + queue.getPlayer());
            new ShowMatrix(matrix).showMatrix();
            temp = validateInput.askInt("Наберите число, куда вы хотите вставить"
                    + (1 == queue.getPlayer() ? " крестик" : " нолик") + " : ");
            try {
                new PutXO().putX(temp, matrix, queue);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так ;(");
            }
        }
        new ShowMatrix(matrix).showMatrix();
    }
}
