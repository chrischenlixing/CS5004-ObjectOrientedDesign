package chess;

public class Pawn extends AbstractChess{

    public Pawn(int row, int column, Color color) {
        super(row, column, color);
        if ((!this.isBlack() && row < 1) || (this.isBlack() && row > 6)){
            throw new IllegalArgumentException("No pawns allowed on the first row");
        }
    }

    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row,col)){
            if (this.isBlack() && this.getRow() == 6){
                return (col == this.getColumn() && (this.getRow() - row == 1 || this.getRow()-row == 2));
            }
            else if (!this.isBlack() && this.getRow() == 1){
                return (col == this.getColumn() && (row - this.getRow() == 1 || row - this.getRow() == 2));
            }
            else if (this.isBlack() && this.getRow() < 6){
                return (col == this.getColumn() && (this.getRow() - row == 1));
            }
            else if (!this.isBlack() && this.getRow() > 1){
                return (col == this.getColumn() && (row - this.getRow() == 1));
            }
        }

            return false;
    }
    @Override
    public boolean canKill(ChessPiece piece) {
        if(piece.getColor()!=this.getColor()) {
            return ((this.isBlack() && Math.abs(this.getColumn() - piece.getColumn()) == 1 && this.getRow() - piece.getRow() == 1) || (!this.isBlack() && Math.abs(this.getColumn() - piece.getColumn()) == 1 && piece.getRow() - this.getRow() == 1));
        }
        return false;
    }
}
