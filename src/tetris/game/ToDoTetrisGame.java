package tetris.game;

import java.util.Random;

//import sun.security.mscapi.KeyStore.MY;
import sun.security.provider.ConfigFile.Spi;
import tetris.game.pieces.MyPiece;
import tetris.game.pieces.MyPieceFactory;
import tetris.game.pieces.Piece;
import tetris.game.pieces.Piece.PieceType;

public class ToDoTetrisGame implements TetrisGame {
	private Board SpielPlatz;
	private Piece stein;
	private Piece nextStein;
	private PieceType pt;
	
	
	
	@Override
	public void addObserver(GameObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(GameObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Piece getCurrentPiece() { // false
		
//		stein = new MyPiece(pt, rot)
		return stein;
	}

	@Override
	public Board getBoard() {
		SpielPlatz = new MyBoard();
		return SpielPlatz;
	}

	@Override
	public Piece getNextPiece() {
		
//		nextStein = new MyPieceFactory().getNextRandomPiece();

		return nextStein;
	}

	@Override
	public int getNumberOfCompletedRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPieceColumn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPieceRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean newPiece() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rotatePieceClockwise() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rotatePieceCounterClockwise() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setGameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

}
