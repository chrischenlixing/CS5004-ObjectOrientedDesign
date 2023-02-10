package chess;

public class Bishop extends AbstractChess{
    public Bishop(int row, int column, Color color) {
        super(row, column, color);
    }

    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row,col)){
            if (Math.abs(col - this.getColumn()) == Math.abs(row - this.getRow())){
                return true;
            }
        }
        return false;
    }
}
