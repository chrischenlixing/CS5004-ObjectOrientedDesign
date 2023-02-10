package chess;

public abstract class AbstractChess implements ChessPiece{
    private final int row;
    private final int column;
    private final Color color;

    public AbstractChess(int row, int column, Color color){
        if (this.outOfBound(row,column)){
            throw new IllegalArgumentException("Placed your piece out of bound!");
        }
        this.row = row;
        this.column = column;
        this.color = color;
    }
    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean canMove(int row, int col) {
        if (this.outOfBound(row,col)){
            throw new IllegalArgumentException("Placed your piece out of bound!");
        }
        if (this.sameLocation(row,col)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        return (this.color != piece.getColor() && this.canMove(piece.getRow(),piece.getColumn()));
    }
    private boolean outOfBound(int row, int column) throws IllegalArgumentException{
        return (row < 0 || column < 0 || row > 7 || column > 7);
    }

    private boolean sameLocation(int row, int column){
        return (this.getRow() == row && this.getColumn() == column);
    }

    public boolean isBlack(){
        return (this.getColor() == Color.BLACK);
    }
}
