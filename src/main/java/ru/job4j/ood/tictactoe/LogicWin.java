package ru.job4j.ood.tictactoe;

public class LogicWin implements LogicInterface {
    private MatMeth mm;
    private QueueInterface queue;
    private MatrixInterface matrix;

    public LogicWin(MatMeth mm, QueueInterface queue, MatrixInterface matrix) {
        this.mm = mm;
        this.queue = queue;
        this.matrix = matrix;
    }

    public boolean isGameEnd() {
        return checkAllMatrix() || checkDiagonals() || checksPossible();
    }

    public boolean checkAllMatrix() {
        boolean rsl = false;
        boolean bRowWin, bColWin;
        for (int i = 0; i < matrix.getSize(); i++) {
            bRowWin = true;
            bColWin = true;
            for (int j = 0; j < matrix.getSize() - 1; j++) {
                bRowWin &= (mm.getXY(i, j).charAt(0) == mm.getXY(i, j + 1).charAt(0));
                bColWin &= (mm.getXY(j, i).charAt(0) == mm.getXY(j + 1, i).charAt(0));
            }
            if (bColWin || bRowWin) {
                System.out.println("Победил игрок " + queue.getPlayer());
                rsl = true;
            }
        }
        return rsl;
    }

    public boolean checkDiagonals() {
        boolean rsl = false;
        boolean bRowWin = true, bColWin = true;
        for (int i = 0; i < matrix.getSize() - 1; i++) {
            bRowWin &= (mm.getXY(i, i).charAt(0) == mm.getXY(i + 1, i + 1).charAt(0));
            bColWin &= (mm.getXY(i, matrix.getSize() - i - 1).charAt(0) == mm.getXY(i + 1, matrix.getSize() - i - 2).charAt(0));
        }
        if (bColWin || bRowWin) {
            System.out.println("Победил игрок " + queue.getPlayer());
            rsl = true;
        }
        return rsl;
    }

    public boolean checksPossible() {
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            switch (mm.getX(i)) {
                case 'O':
                case 'X':
                    break;
                default:
                    return false;
            }
        }
        System.out.println("Ничья. Кончились ходы.");
        return true;
    }

}
