package chess;

public class Knight extends AbstractChess{

    public Knight(int row, int column, Color color) {
        super(row, column, color);
    }

    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row,col)){
            return (Math.abs(col - this.getColumn()) == 2 && Math.abs(row - this.getRow()) == 1) || (Math.abs(col - this.getColumn()) == 1 && Math.abs(row - this.getRow()) == 2);
        }
        return false;
    }
}
