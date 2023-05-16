package chess;

public class King extends AbstractChess{
    public King(int row, int column, Color color) {
        super(row, column, color);
    }


    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row,col)){
            return ((Math.abs(col - this.getColumn()) == 1) && (Math.abs(row - this.getRow()) == 0)) || ((Math.abs(col - this.getColumn()) == 0) && (Math.abs(row - this.getRow()) == 1)|| ((Math.abs(col - this.getColumn()) == 1) && (Math.abs(row - this.getRow()) == 1)));
        }
        return false;
    }
}
