package chess;

public class Rook extends AbstractChess{
    public Rook(int row, int column, Color color) {
        super(row, column, color);
    }
    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row,col)){
            return ((col != this.getColumn()) && (row == this.getRow())||(col == this.getColumn()) && (row != this.getRow()));
        }
        return false;
    }
}
