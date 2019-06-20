package tetris.game.pieces;

public class MyPiece implements Piece {

	private boolean[][] piece;
	private PieceType pieceType;
	private Point rotationPoint;
	 
	public MyPiece(PieceType pt) throws Exception {

		pieceType = pt;
		switch (pieceType) {
		case I:
			piece = new boolean[4][1];
			rotationPoint = new Point(1, 0);
			piece[0][0] = true;
			piece[1][0] = true;
			piece[2][0] = true;
			piece[3][0] = true;
			piece[0][1] = false;
			piece[1][1] = false;
			piece[2][1] = false;
			piece[3][1] = false;
			break;
		case J:
			piece = new boolean[3][2];
			rotationPoint = new Point(1, 1);
			piece[0][0] = false;
			piece[1][0] = false;
			piece[2][0] = true;
			piece[0][1] = true;
			piece[1][1] = true;
			piece[2][1] = true;
			break;
		case L:
			piece = new boolean[3][2];
			rotationPoint = new Point(1, 0);
			piece[0][0] = true;
			piece[1][0] = true;
			piece[2][0] = true;
			piece[0][1] = false;
			piece[1][1] = false;
			piece[2][1] = true;
			break;
		case O:
			piece = new boolean[2][2];
			rotationPoint = new Point(1, 1);
			piece[0][0] = true;
			piece[1][0] = true;
			piece[0][1] = true;
			piece[1][1] = true;
			break;
		case S:
			piece = new boolean[2][3];
			rotationPoint = new Point(1, 1);
			piece[0][0] = false;
			piece[0][1] = true;
			piece[0][2] = true;
			piece[1][0] = true;
			piece[1][1] = true;
			piece[1][2] = false;
			break;
		case T:
			piece = new boolean[2][3];
			rotationPoint = new Point(0, 1);
			piece[0][0] = true;
			piece[0][1] = true;
			piece[0][2] = true;
			piece[1][0] = false;
			piece[1][1] = true;
			piece[1][2] = false;
			break;
		case Z:
			piece = new boolean[2][3];
			rotationPoint = new Point(1, 1);
			piece[0][0] = true;
			piece[0][1] = true;
			piece[0][2] = false;
			piece[1][0] = false;
			piece[1][1] = true;
			piece[1][2] = true;
			break;
		default:
			throw new Exception("Unkown piecetype");
		}

	}

	@Override
	public int getWidth() {
		return piece[0].length;
	}

	@Override
	public int getHeight() {
		return piece.length;
	}

	@Override
	public boolean[][] getBody() {
		return piece;
	}

	@Override
	public Piece getClockwiseRotation() {
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece getCounterClockwiseRotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getRotationPoint() {
		return rotationPoint;
	}

	@Override
	public PieceType getPieceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
