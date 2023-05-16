import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.Bishop;
import chess.Color;
import chess.King;
import chess.Knight;
import chess.Pawn;
import chess.Queen;
import chess.Rook;

import static org.junit.jupiter.api.Assertions.*;

class ChessTest {

    private Pawn pawn1;
    private Pawn pawn2;
    private Pawn pawn3;

    private Pawn pawn4;
    private Bishop bishop1;
    private Bishop bishop2;
    private King king1;
    private King king2;
    private Knight knight1;
    private Knight knight2;
    private Queen queen1;
    private Queen queen2;
    private Rook rook1;
    private Rook rook2;

    @BeforeEach
    public void setup(){
        pawn1 = new Pawn(1,0, Color.WHITE);
        pawn2 = new Pawn(3,2,Color.WHITE);
        pawn3 = new Pawn(4,3,Color.BLACK);
        assertThrows(IllegalArgumentException.class, ()-> pawn4 = new Pawn(0,0, Color.WHITE));
        bishop1 = new Bishop(0,2,Color.WHITE);
        bishop2 = new Bishop(5,3, Color.BLACK);
        king1 = new King(0,3,Color.WHITE);
        king2 = new King(7,3,Color.BLACK);
        knight1 = new Knight(0,1,Color.WHITE);
        knight2 = new Knight(7,1, Color.BLACK);
        queen1 = new Queen(0,5,Color.WHITE);
        queen2 = new Queen(6,4,Color.BLACK);
        rook1 = new Rook(0,0,Color.WHITE);
        rook2 = new Rook(7,0,Color.BLACK);
    }

    @Test
    public void testGetRow(){
        assertEquals(1,pawn1.getRow());
        assertEquals(7,king2.getRow());
    }

    @Test
    public void testGetColumn(){
        assertEquals(5,queen1.getColumn());
        assertEquals(0,rook2.getColumn());
    }

    @Test
    public void testGetColor(){
        assertEquals(Color.WHITE,rook1.getColor());
        assertEquals(Color.BLACK,rook2.getColor());
    }

    @Test
    public void testCanMove(){
        assertTrue(pawn1.canMove(3,0));
        assertFalse(pawn2.canMove(5,2));
        assertFalse(pawn1.canMove(1,0));
        assertTrue(bishop1.canMove(2,0));
        assertFalse(bishop2.canMove(5,2));
        assertFalse(bishop1.canMove(0,2));
        assertTrue(king1.canMove(1,3));
        assertFalse(king2.canMove(5,3));
        assertFalse(king1.canMove(0,3));
        assertTrue(knight1.canMove(2,0));
        assertFalse(knight2.canMove(7,0));
        assertFalse(knight1.canMove(0,3));
        assertTrue(queen1.canMove(7,5));
        assertTrue(queen1.canMove(0,0));
        assertTrue(queen1.canMove(5,0));
        assertFalse(queen2.canMove(4,3));
        assertFalse(queen1.canMove(0,5));
        assertTrue(rook1.canMove(0,7));
        assertFalse(rook2.canMove(6,1));
        assertFalse(rook1.canMove(0,0));
        assertThrows(IllegalArgumentException.class, ()-> pawn1.canMove(-1,-1));
        assertThrows(IllegalArgumentException.class, ()-> bishop1.canMove(8,8));
        assertThrows(IllegalArgumentException.class, ()-> king1.canMove(-1,-1));
        assertThrows(IllegalArgumentException.class, ()-> knight1.canMove(8,8));
        assertThrows(IllegalArgumentException.class, ()-> queen1.canMove(-1,-1));
        assertThrows(IllegalArgumentException.class, ()-> rook1.canMove(8,8));
    }

    @Test
    public void testCanKill(){
        assertTrue(pawn3.canKill(new Pawn(3,2,Color.WHITE)));
        assertFalse(pawn3.canKill(new Pawn(3,3,Color.WHITE)));
        assertTrue(bishop1.canKill(new Bishop(1,3,Color.BLACK)));
        assertFalse(bishop2.canKill(new Bishop(0,0,Color.BLACK)));
        assertTrue(king1.canKill(new King(0,2,Color.BLACK)));
        assertFalse(king1.canKill(new King(0,0,Color.BLACK)));
        assertTrue(knight1.canKill(new Knight(2,2,Color.BLACK)));
        assertFalse(knight1.canKill(new Knight(0,0,Color.BLACK)));
        assertTrue(queen1.canKill(new Queen(0,0,Color.BLACK)));
        assertFalse(queen1.canKill(new Queen(0,0,Color.WHITE)));
        assertTrue(rook1.canKill(new Rook(7,0,Color.BLACK)));
        assertFalse(rook1.canKill(new Rook(7,1,Color.WHITE)));
    }

}