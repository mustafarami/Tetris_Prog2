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
	private GameObserver GaOb;

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
		this.numberOfCompletedRows = 0;
		this.points = 0;
		this.Abdo = 0;
	}

	@Override
	public void addObserver(GameObserver observer) {
//		 TODO Auto-generated method stub
		this.GaOb = observer;

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
			Piece newStein = this.pf.getNextRandomPiece();
			this.stein= newStein;

		}
		return this.stein;
	}

	@Override
	public int getNumberOfCompletedRows() {
		int num = 0;
		boolean complet = true;

		for (int i = SpielPlatz.getNumberOfRows() - 1; i > -1; i--) {
			for (int j = 0; j < SpielPlatz.getNumberOfColumns(); j++) {
				if (SpielPlatz.getBoard()[i][j] == null) {
					complet = false;
					break;
				}else {
					System.out.println("tt");
				}
			}
			if (complet) {
				num++;

				complet = true;

			}
		}

		return num;
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
			Abdo += 1000;
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
			SpielPlatz.removePiece(this.stein, getPieceRow(), getPieceColumn());
			this.pieceRow++;

			if ((SpielPlatz.canAddPiece(this.stein, this.pieceRow, this.pieceColoumn))) {
				SpielPlatz.addPiece(this.stein, this.pieceRow, this.pieceColoumn);

				return true;
			} else {
				this.pieceRow--;
				SpielPlatz.addPiece(this.stein, this.pieceRow, this.pieceColoumn);
			}

		} catch (IllegalArgumentException e) {
           return false;
		}

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
		try {

			if (getNumberOfCompletedRows() == 0) {
				this.pieceRow = 2;
				System.out.println("rows" + getNumberOfCompletedRows());
				this.pieceColoumn = this.SpielPlatz.getNumberOfColumns() / 2;
				if (!this.SpielPlatz.canAddPiece(stein, this.pieceRow, this.pieceColoumn)) {
					setGameOver();
					return false;
				
				} else {
//					getPoints();
//					this.pieceRow = 2;
//					this.pieceColoumn = this.SpielPlatz.getNumberOfColumns() / 2;
					this.SpielPlatz.addPiece(stein, this.pieceRow, this.pieceColoumn);
					return true;
				}
			} else {
				this.pieceRow = 2;
				this.pieceColoumn = this.SpielPlatz.getNumberOfColumns() / 2;
				this.points = this.SpielPlatz.deleteCompleteRows();

				if (!this.SpielPlatz.canAddPiece(stein, this.pieceRow, this.pieceColoumn)) {
					setGameOver();
					return false;
					
				} else {

//					this.pieceRow = 2;
//					this.pieceColoumn = this.SpielPlatz.getNumberOfColumns() / 2;
					this.SpielPlatz.addPiece(stein, this.pieceRow, this.pieceColoumn);
					return true;
				}

			}

		} catch (IllegalArgumentException e) {

			return false;

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
		if (this.GaOb != null) {
			this.GaOb.gameOver();
         
	}
	}

	@Override
	public void step() {

		if (moveDown()) {
		}
		else {
	           if(this.GaOb != null) {
	        	   GaOb.pieceLanded();
	           }
			}

		
		
		if (newPiece()) {
			
		}
		}

	}


