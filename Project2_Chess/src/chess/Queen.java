package chess;

public class Queen extends AbstractChess{
    public Queen(int row, int column, Color color) {
        super(row, column, color);
    }
    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row,col)) {
            return (((col != this.getColumn()) && row == this.getRow()) || (((col == this.getColumn())) && (row != this.getRow()))|| Math.abs(row - this.getRow()) == Math.abs(col - this.getColumn()));
        }
        return false;
    }
}
