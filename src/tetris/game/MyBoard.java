package tetris.game;

//import java.util.Arrays;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import prog2.tests.tetris.pub.PieceTest;
import tetris.game.pieces.Piece;
import tetris.game.pieces.Piece.PieceType;
import tetris.game.pieces.Point;

public class MyBoard implements Board {
	private int height = 0;
	private int width = 0;
	private PieceType[][] board;
	private boolean[][] Body;

	public MyBoard(int h, int w) {
		this.height = h;
		this.width = w;
		board = new PieceType[height][width];
	}

	@Override
	public PieceType[][] getBoard() {
		return board;
	}

	@Override
	public int getNumberOfRows() { // ?
		return board.length;
	}

	@Override
	public int getNumberOfColumns() { // ?
		return board[0].length;
	}

	@Override
	public void addPiece(Piece piece, int row, int column) {
		if (canAddPiece(piece, row, column)) {
			PieceType pt = piece.getPieceType();

			int x = piece.getRotationPoint().getRow(); // it was Rotation_Point.getRow()/.getColumn()
			int y = piece.getRotationPoint().getColumn();
			int x0 = 0;
			int y0 = 0;
			Body = piece.getBody();

			for (int i = 0; i < Body.length; i++) {

				for (int j = 0; j < Body[0].length; j++) {
					x0 = i - x;
					y0 = j - y;
					if (Body[i][j]) {
						board[x0 + row][y0 + column] = pt;
					}
				}
			}

		} else {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public boolean canAddPiece(Piece piece, int row, int column)  {
		if (row >= getNumberOfRows() || column >= getNumberOfColumns()) {
			return false;
		}
		if (piece == null) {
			throw new IllegalArgumentException();
		}
		int x = piece.getRotationPoint().getRow(); // it was Rotation_Point.getRow()/.getColumn()
		int y = piece.getRotationPoint().getColumn();
		int x0 = 0;
		int y0 = 0;
		boolean logik = false;
		Body = piece.getBody();

		for (int i = 0; i < Body.length; i++) {
			for (int j = 0; j < Body[0].length; j++) {
				if (Body[i][j]) {
					x0 = i - x;
					y0 = j - y;

					if (x0 + row < 0 || x0 + row >= height || y0 + column < 0 || y0 + column >= width) {
						return false;
					} // added new
					if (board[x0 + row][y0 + column] == null) {
						logik = true;
					} else {
						return false;
					}

				}
			}

		}
		return logik;
	}

	@Override
	public void removePiece(Piece piece, int row, int column) {

		if (canRemovePiece(piece, row, column)) {

			int x = piece.getRotationPoint().getRow(); // it was Rotation_Point.getRow()/.getColumn()
			int y = piece.getRotationPoint().getColumn();
			int x0 = 0;
			int y0 = 0;
			Body = piece.getBody();

			for (int i = 0; i < Body.length; i++) {
				for (int j = 0; j < Body[0].length; j++) {
					if (Body[i][j]) {
						x0 = i - x;
						y0 = j - y;
						board[x0 + row][y0 + column] = null;
					}
				}
			}

		} else {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public boolean canRemovePiece(Piece piece, int row, int column) {

		int x = piece.getRotationPoint().getRow(); // it was Rotation_Point.getRow()/.getColumn()
		int y = piece.getRotationPoint().getColumn();
		int x0 = 0;
		int y0 = 0;
		boolean logik = false;
		PieceType pt = piece.getPieceType();
		Body = piece.getBody();

		for (int i = 0; i < Body.length; i++) {
			for (int j = 0; j < Body[0].length; j++) {
				if (Body[i][j]) {
					x0 = i - x;
					y0 = j - y;
					if (x0 + row < 0 || x0 + row >= height || y0 + column < 0 || y0 + column >= width) {
						return false;
					} // added new

					if (pt.equals(board[x0 + row][y0 + column])) {
						logik = true;
					} else {
						return false;
					}

				}
			}

		}
		return logik;

	}

	@Override
	public int deleteCompleteRows() { // don't forget the mistake you've thought about it, before you sleep.

		int rows = getNumberOfRows() - 1;
		int last_row = 4;
		int ret = 0;
		boolean geht = true;

		for (int r = 0; r < getNumberOfRows(); r++) {
			
//			rows = getNumberOfRows() - 1;
			
			for (int i = 0; i < getNumberOfColumns(); i++) { // check if a row is completed
				if (board[rows][i] != null) {
					geht &= true;
				} else {
					geht = false;
					break;
				}
			}

			if (geht) { // delete an completed Row
				for (int i = 0; i < getNumberOfColumns(); i++) {
					board[rows][i] = null;
				}
				if (last_row == 0) {
					break;
				}
				for (int j = 0; j < getNumberOfColumns(); j++) {
					board[rows][j] = board[rows - 1][j];
				}

				for (int i = rows - 1; i > 0; i--) {
					for (int j = 0; j < getNumberOfColumns(); j++) {
						board[i][j] = board[i - 1][j];
						if (i == 1) {
							board[0][j] = null;
						}
					}
					if (i == 1) {
						break;
					}
				}
//				rows--;
				ret++;
				last_row--;
			} else {
				rows--;

			}
			geht = true;
		}
		return ret;
	}

	@Override
	public Board clone() {

		Board newBoard = null;
		newBoard = new MyBoard(board.length, board[0].length);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				newBoard.getBoard()[i][j] = board[i][j];
			}
		}

		return newBoard;
	}

}
