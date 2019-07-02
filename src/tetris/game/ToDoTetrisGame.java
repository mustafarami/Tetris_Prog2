package tetris.game;

import java.util.Random;

//import com.sun.org.apache.bcel.internal.generic.CPInstruction;

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
	private int points;
	private PieceFactory pf;
	private int Row;
	private int Coloumn;
	private int pieceColoumn;
	private int pieceRow;
	private long Abdo;

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
		this.points = 0;
		this.Abdo = 0;
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
//		SpielPlatz = new MyBoard(MyTetrisFactory.DEFAULT_ROWS, MyTetrisFactory.DEFAULT_COLUMNS);
		return SpielPlatz;
	}

	@Override
	public Piece getNextPiece() {
		if (newPiece()) {
			this.stein = this.pf.getNextRandomPiece();

		}
		return this.stein;
	}

	@Override
	public int getNumberOfCompletedRows() {
		int num = 0;
		boolean complet = true;

		for (int i = SpielPlatz.getNumberOfRows() - 1; i > -1; i--) {
			for (int j = 0; j < SpielPlatz.getNumberOfColumns(); j++) {
				if (SpielPlatz.getBoard()[i][j] != null) {
					complet &= true;
				} else {
					complet = false;
					break;
				}
			}
			if (complet) {
				num++;
			} else {
				complet = true;
			}

		}

		numberOfCompletedRows = num;
		return numberOfCompletedRows;
	}

	@Override
	public int getPieceColumn() {

		return this.pieceColoumn;
	}

	@Override
	public int getPieceRow() {

		return this.pieceRow;
	}

	@Override
	public long getPoints() {
		switch (this.points) {
		case 1:
			Abdo += 100;
			break;
		case 2:
			Abdo += 300;
			break;
		case 3:
			Abdo += 500;
			break;
		case 4:
			Abdo += 100;
			break;
		default:
			break;
		}

		return Abdo;
	}

	@Override
	public boolean isGameOver() {

		return false;
	}

	@Override
	public boolean moveDown() {
		try {
			SpielPlatz.removePiece(getCurrentPiece(), getPieceRow(), getPieceColumn());

			if ((SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow() + 1, getPieceColumn()))) {
				SpielPlatz.addPiece(getCurrentPiece(), getPieceRow() + 1, getPieceColumn());
				this.pieceRow += 1;
				return true;
			}

		} catch (IllegalArgumentException e) {

		}
		SpielPlatz.addPiece(getCurrentPiece(), getPieceRow(), getPieceColumn());
		return false;

	}

	@Override
	public boolean moveLeft() { ///// check here
//		if (!SpielPlatz.canRemovePiece(getCurrentPiece(), getPieceRow(), getPieceColumn())) {
//			return false;
//		}

		try {
			SpielPlatz.removePiece(getCurrentPiece(), getPieceRow(), getPieceColumn());

			if ((SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() - 1))) {
				SpielPlatz.addPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() - 1);
				this.pieceColoumn -= 1;
				return true;
			}

		} catch (IllegalArgumentException e) {

		}
		SpielPlatz.addPiece(getCurrentPiece(), getPieceRow(), getPieceColumn());
		return false;

//		this.pieceColoumn = getPieceColumn() -1;
//		nextStein = getCurrentPiece();

//		return false;
	}

	@Override
	public boolean moveRight() {
		try {
			SpielPlatz.removePiece(getCurrentPiece(), getPieceRow(), getPieceColumn());

			if ((SpielPlatz.canAddPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() + 1))) {
				SpielPlatz.addPiece(getCurrentPiece(), getPieceRow(), getPieceColumn() + 1);
				this.pieceColoumn += 1;
				return true;
			}

		} catch (IllegalArgumentException e) {

		}
		SpielPlatz.addPiece(getCurrentPiece(), getPieceRow(), getPieceColumn());
		return false;

	}

	@Override
	public boolean newPiece() {
		if (numberOfCompletedRows == 0) {
			this.pieceRow = 2;
			this.pieceColoumn = this.SpielPlatz.getNumberOfColumns() / 2;
			if (!this.SpielPlatz.canAddPiece(stein, this.pieceRow, this.pieceColoumn)) {
				return false;
			} else {
//				getPoints();
				this.pieceRow = 2;
				this.pieceColoumn = this.SpielPlatz.getNumberOfColumns() / 2;
				this.SpielPlatz.addPiece(stein, this.pieceRow, this.pieceColoumn);
				return true;
			}
		} else {
			this.pieceRow = 2;
			this.pieceColoumn = this.SpielPlatz.getNumberOfColumns() / 2;
			this.points = this.SpielPlatz.deleteCompleteRows();
			if (!this.SpielPlatz.canAddPiece(stein, this.pieceRow, this.pieceColoumn)) {
				return false;
			} else {

				this.pieceRow = 2;
				this.pieceColoumn = this.SpielPlatz.getNumberOfColumns() / 2;
				this.SpielPlatz.addPiece(stein, this.pieceRow, this.pieceColoumn);
				return true;
			}

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
		if (moveDown()) {

		} else {
			newPiece();
		}

	}

}
