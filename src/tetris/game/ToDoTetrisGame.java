package tetris.game;

import java.util.Random;

import tetris.game.pieces.MyPieceFactory;
//import sun.security.mscapi.KeyStore.MY;
//import sun.security.provider.ConfigFile.Spi;
//import tetris.game.pieces.MyPiece;
//import tetris.game.pieces.MyPieceFactory;
import tetris.game.pieces.Piece;
import tetris.game.pieces.Piece.PieceType;
import tetris.game.pieces.PieceFactory;

public class ToDoTetrisGame implements TetrisGame {
	private Board SpielPlatz;
	private Piece stein;
	private Piece nextStein;
	private PieceType pt;
	private Random random;
	private int numberOfCompletedRows;
	private long points;
	private PieceFactory pf;

	public void SetBoard(Board b) {
		this.SpielPlatz = b;
	}

	public ToDoTetrisGame(Random r) {
		super();
		this.random = r;
		pf = MyTetrisFactory.createPieceFactory(r);
		numberOfCompletedRows = 0;
		points = 0;
	}

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
		return nextStein;
	}

	@Override
	public Board getBoard() { 
		SpielPlatz = new MyBoard(MyTetrisFactory.DEFAULT_COLUMNS, MyTetrisFactory.DEFAULT_ROWS);
		return SpielPlatz;
	}

	@Override
	public Piece getNextPiece() {
		nextStein = new MyPieceFactory(random).getNextRandomPiece();
		return nextStein;
	}

	@Override
	public int getNumberOfCompletedRows() {
		return numberOfCompletedRows;
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
			return points;
	}

	@Override
	public boolean isGameOver() {

		return false;
	}

	@Override
	public boolean moveDown() {
		return SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow() + 1, getPieceColumn());
	}

	@Override
	public boolean moveLeft() {

		return SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() - 1);
	}

	@Override
	public boolean moveRight() {

		return SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() + 1);
	}

	@Override
	public boolean newPiece() {
		return false;
	}

	@Override
	public boolean rotatePieceClockwise() {

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
		int deletedRows = SpielPlatz.deleteCompleteRows();
		numberOfCompletedRows += deletedRows;
		// TODO POINTS
		
		Piece p = null;
		
		if(nextStein != null) {
			p = nextStein;
		} else {
			p = pf.getNextRandomPiece();
		}
		
		nextStein = pf.getNextRandomPiece();
		
		// TODO richtige startposition
		if(SpielPlatz.canAddPiece(p, 0, 0)) {
			
			SpielPlatz.addPiece(p, 0, 0);
			stein = p;
			
		} else {
			setGameOver();
		}

	}

}
