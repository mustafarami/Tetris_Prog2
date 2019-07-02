package tetris.game;

import java.util.Random;

//import sun.security.provider.ConfigFile.Spi;
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
//	private Random random;
	private int numberOfCompletedRows;
	private long points;
	private PieceFactory pf;
	private int Row;
	private int Coloumn;
	private int pieceColoumn;
	private int pieceRow;

	public void SetBoard(Board b) {
		this.SpielPlatz = b;
	}

	public ToDoTetrisGame(MyPieceFactory piece, Board b) {
		super();
//		this.random = r;
		this.pf = piece;
		this.Row = b.getNumberOfRows();
		this.Coloumn = b.getNumberOfColumns();
		this.SpielPlatz = b;
		this.stein = piece.getNextRandomPiece();

//		pf = MyTetrisFactory.createPieceFactory(r);
		numberOfCompletedRows = 0;
		points = 0;
	}

	@Override
	public void addObserver(GameObserver observer) {
//		 TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(GameObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Piece getCurrentPiece() { // false
//		this.stein = nextStein;
		return stein;
	}

	@Override
	public Board getBoard() {
		SpielPlatz = new MyBoard(MyTetrisFactory.DEFAULT_COLUMNS, MyTetrisFactory.DEFAULT_ROWS);
		return SpielPlatz;
	}

	@Override
	public Piece getNextPiece() {
		nextStein = this.pf.getNextRandomPiece();
		return nextStein;
	}

	@Override
	public int getNumberOfCompletedRows() {
		return numberOfCompletedRows;
	}

	@Override
	public int getPieceColumn() {

		return pieceColoumn;
	}

	@Override
	public int getPieceRow() {

		return pieceRow;
	}

	@Override
	public long getPoints() {
		switch (numberOfCompletedRows) {
		case 1:
			points += 100;
			break;
		case 2:
			points += 300;
			break;
		case 3:
			points += 500;
			break;
		case 4:
			points += 100;
			break;
		default:
			break;
		}

		return points;
	}

	@Override
	public boolean isGameOver() {

		return false;
	}

	@Override
	public boolean moveDown() {
		SpielPlatz.removePiece(getCurrentPiece(), getPieceRow(), getPieceColumn());
		try {
			if (!SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow() + 1, getPieceColumn())) {
				SpielPlatz.addPiece(stein, getPieceRow(), getPieceColumn());
				return false;
			}

		} catch (IllegalArgumentException e) {
			
		}
		SpielPlatz.addPiece(getCurrentPiece(), getPieceRow() + 1, getPieceColumn());
		this.pieceRow += 1;
		nextStein = getCurrentPiece();
		return true;

	}

	@Override
	public boolean moveLeft() { ///// check here

		SpielPlatz.removePiece(getCurrentPiece(), getPieceRow(), getPieceColumn());
		try {
			if (!SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() - 1)) {
				SpielPlatz.addPiece(stein, getPieceRow(), getPieceColumn());
				return false;
			}

		} catch (IllegalArgumentException e) {

		}
		SpielPlatz.addPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() - 1);
		this.pieceColoumn -= 1;
		nextStein = getCurrentPiece();
		return true;

	}

	@Override
	public boolean moveRight() {
		SpielPlatz.removePiece(getCurrentPiece(), getPieceRow(), getPieceColumn());
		if (!SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() + 1)) {
			SpielPlatz.addPiece(getCurrentPiece(), getPieceRow(), getPieceColumn());

			return false;
		} else {
			SpielPlatz.addPiece(stein, getPieceRow(), getPieceColumn() + 1);
			this.pieceColoumn += 1;
			return true;
		}
	}

	@Override
	public boolean newPiece() {
		int x = 0;
		if (!SpielPlatz.canAddPiece(getNextPiece(), 2, SpielPlatz.getNumberOfColumns() / 2)) {
			return false;
		} else {
			x = SpielPlatz.deleteCompleteRows();
			this.numberOfCompletedRows = x;
			getPoints();
			SpielPlatz.addPiece(getCurrentPiece(), 2, SpielPlatz.getNumberOfColumns() / 2);
			this.pieceRow = 2;
			this.pieceColoumn = SpielPlatz.getNumberOfColumns() / 2;
			return true;
		}
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
		if (!moveDown()) {
			if (!newPiece()) {

				Piece p = null;

				if (nextStein != null) {
					p = nextStein;
				} else {
					p = pf.getNextRandomPiece();
				}

				nextStein = pf.getNextRandomPiece();

//				if (SpielPlatz.canAddPiece(p, 2, SpielPlatz.getNumberOfColumns() / 2)) {
//
//					SpielPlatz.addPiece(p, 2, SpielPlatz.getNumberOfColumns() / 2);
				stein = p;

//				} else 

			}
		}
		setGameOver();
	}

}
