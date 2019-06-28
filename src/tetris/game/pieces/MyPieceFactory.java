package tetris.game.pieces;

import java.util.Random;

import tetris.game.pieces.MyPiece.Rotation_time;
import tetris.game.pieces.Piece.PieceType;

public class MyPieceFactory implements PieceFactory {
	
	private Random random;
	public MyPieceFactory(Random r) {
		// TODO Auto-generated constructor stub
		super();
		this.random = r;
	}

	@Override
	public Piece getIPiece() {
		Piece piece = new MyPiece(PieceType.I, Rotation_time.first);
		return piece;		
	}

	@Override
	public Piece getJPiece() {
		Piece piece = new MyPiece(PieceType.J, Rotation_time.first);
		return piece;
	}

	@Override
	public Piece getLPiece() {
		Piece piece = new MyPiece(PieceType.L, Rotation_time.first);
		return piece;
	}

	@Override
	public Piece getOPiece() {
		Piece piece = new MyPiece(PieceType.O, Rotation_time.first);
		return piece;
	}

	@Override
	public Piece getSPiece() {
		Piece piece = new MyPiece(PieceType.S, Rotation_time.first);
		return piece;
	}

	@Override
	public Piece getZPiece() {
		Piece piece = new MyPiece(PieceType.Z, Rotation_time.first);
		return piece;
	}

	@Override
	public Piece getTPiece() {
		Piece piece = new MyPiece(PieceType.T, Rotation_time.first);
		return piece;
	}

	@Override
	public Piece getNextRandomPiece() {
		int random_num = this.random.nextInt(7);
		Piece piece = null;
		switch (random_num) {
		case 0:
			piece = getIPiece();
			break;
		case 1:
			piece = getJPiece();
			break;
		case 2:
			piece = getLPiece();
			break;
		case 3:
			piece = getOPiece();
			break;
		case 4:
			piece = getSPiece();
			break;
		case 5:
			piece = getTPiece();
			break;
		case 6:
			piece = getZPiece();
			break;
		default:
			break;
		}
		return piece;
	}

}
