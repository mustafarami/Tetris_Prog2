package tetris.game.pieces;

public class MyPiece implements Piece {

	private boolean[][] piece;
	private PieceType pieceType;
	private Point rotationPoint;
	private Rotation_time rotation;

	boolean[][] I_one = { { true }, { true }, { true }, { true } };
	boolean[][] I_two = { { true, true, true, true } };
	boolean[][] J_one = { { false, true }, { false, true }, { true, true } };
	boolean[][] J_two = { { true, false, false }, { true, true, true } };
	boolean[][] J_three = { { true, true }, { true, false }, { true, false } };
	boolean[][] J_four = { { true, true, true }, { false, false, true } };
	boolean[][] L_one = { { true, false }, { true, false }, { true, true } };
	boolean[][] L_two = { { true, true, true }, { true, false, false } }; // (0, 1)
	boolean[][] L_three = { { true, true }, { false, true }, { false, true } }; // (1, 1)
	boolean[][] L_four = { { false, false, true }, { true, true, true } }; // (1, 1)
	boolean[][] O_one = { { true, true }, { true, true } };
	boolean[][] S_one = { { false, true, true }, { true, true, false } };
	boolean[][] S_two = { { true, false }, { true, true }, { false, true } }; // (1, 0)
	boolean[][] T_one = { { true, true, true }, { false, true, false } };
	boolean[][] T_tow = { { false, true }, { true, true }, { false, true } }; // (1, 1)
	boolean[][] T_three = { { false, true, false }, { true, true, true } }; // (1, 1)
	boolean[][] T_four = { { true, false }, { true, true }, { true, false } }; // (1, 0)
	boolean[][] Z_one = { { true, true, false }, { false, true, true } };
	boolean[][] Z_two = { { false, true }, { true, true }, { true, false } }; // (1, 0)

	enum Rotation_time {
		first, secound, third, fourth;
	}

	public MyPiece(PieceType pt, Rotation_time rot) {
		rotation = rot;
		pieceType = pt;
		switch (pieceType) {
		case I:

			piece = new boolean[4][1];
			rotationPoint = new Point(1, 0);
			piece[0][0] = true;
			piece[1][0] = true;
			piece[2][0] = true;
			piece[3][0] = true;
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
		}

		if (rot == Rotation_time.secound) { // the true one
			MyPiece p = (MyPiece) getClockwiseRotation();
			this.piece = p.piece;
			this.rotation = p.rotation;
			this.rotationPoint = p.rotationPoint;
		}

		if (rot == Rotation_time.third) {
			MyPiece p = (MyPiece) (getClockwiseRotation()).getClockwiseRotation();
			this.piece = p.piece;
			this.rotation = p.rotation;
			this.rotationPoint = p.rotationPoint;
		}

		if (rot == Rotation_time.fourth) {
			MyPiece p = (MyPiece) getCounterClockwiseRotation();
			this.piece = p.piece;
			this.rotation = p.rotation;
			this.rotationPoint = p.rotationPoint;
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
		MyPiece p = new MyPiece(pieceType, rotation);
		switch (pieceType) {
		case I:
			switch (rotation) {
			case first:
				p.piece = I_two;
				p.rotationPoint = new Point(0, 2);
				p.rotation = Rotation_time.secound;
				break;
			case secound:
				p.piece = I_one;
				p.rotationPoint = new Point(2, 0);
				p.rotation = Rotation_time.third;
				break;
			case third:
				p.piece = I_two;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case fourth:
				p.piece = I_one;
				p.rotationPoint = new Point(0, 2);

				p.rotation = Rotation_time.first;

				break;
			default:
				break;
			}
		case J:
			switch (rotation) {
			case first:
				p.piece = J_two;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.secound;
				break;
			case secound:
				p.piece = J_three;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.third;
				break;
			case third:
				p.piece = J_four;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case fourth:
				p.piece = J_one;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		case L:
			switch (rotation) {
			case first:
				p.piece = L_two;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.secound;
				break;
			case secound:
				p.piece = L_three;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.third;
				break;
			case third:
				p.piece = L_four;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case fourth:
				p.piece = L_one;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.first;
				break;
			default:
				break;
			}

		case O:
			switch (rotation) {
			case first:
				p.piece = O_one;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.secound;
				break;
			case secound:
				p.piece = O_one;
				p.rotationPoint = new Point(0, 0);
				p.rotation = Rotation_time.third;
				break;
			case third:
				p.piece = O_one;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case fourth:
				p.piece = O_one;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		case S:
			switch (rotation) {
			case first:
				p.piece = S_two;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.secound;
				break;
			case secound:
				p.piece = S_one;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.third;
				break;
			case third:
				p.piece = S_two;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case fourth:
				p.piece = S_one;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		case T:
			switch (rotation) {
			case first:
				p.piece = T_tow;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.secound;
				break;
			case secound:
				p.piece = T_three;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.third;
				break;
			case third:
				p.piece = T_four;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case fourth:
				p.piece = T_one;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		case Z:
			switch (rotation) {
			case first:
				p.piece = Z_two;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.secound;
				break;
			case secound:
				p.piece = Z_one;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.third;
				break;
			case third:
				p.piece = Z_two;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case fourth:
				p.piece = Z_one;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		default:
			break;
		}

		return p;
	}

	@Override
	public Piece getCounterClockwiseRotation() {
		MyPiece p = new MyPiece(pieceType, rotation);
		switch (pieceType) {
		case I:
			switch (rotation) {
			case first:
				p.piece = I_two;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case secound:
				p.piece = I_one;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.first;
				break;
			case third:
				p.piece = I_two;
				p.rotationPoint = new Point(0, 2);
				p.rotation = Rotation_time.secound;
				break;
			case fourth:
				p.piece = I_one;
				p.rotationPoint = new Point(2, 0);
				p.rotation = Rotation_time.third;
				break;
			default:
				break;
			}
		case J:
			switch (rotation) {
			case first:
				p.piece = J_four;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case secound:
				p.piece = J_one;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.first;
				break;
			case third:
				p.piece = J_two;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.secound;
				break;
			case fourth:
				p.piece = J_three;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.third;
				break;
			default:
				break;
			}
		case L:
			switch (rotation) {
			case first:
				p.piece = L_four;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case secound:
				p.piece = L_one;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.first;
				break;
			case third:
				p.piece = L_two;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.secound;
				break;
			case fourth:
				p.piece = L_three;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.third;
				break;
			default:
				break;
			}

		case O:
			switch (rotation) {
			case first:
				p.piece = O_one;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case secound:
				p.piece = O_one;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.first;
				break;
			case third:
				p.piece = O_one;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.secound;
				break;
			case fourth:
				p.piece = O_one;
				p.rotationPoint = new Point(0, 0);
				p.rotation = Rotation_time.third;
				break;
			default:
				break;
			}
		case S:
			switch (rotation) {
			case first:
				p.piece = S_two;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case secound:
				p.piece = S_one;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.first;
				break;
			case third:
				p.piece = S_two;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.secound;
				break;
			case fourth:
				p.piece = S_one;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.third;
				break;
			default:
				break;
			}
		case T:
			switch (rotation) {
			case first:
				p.piece = T_four;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.fourth;
				break;
			case secound:
				p.piece = T_one;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.first;
				break;
			case third:
				p.piece = T_tow;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.secound;
				break;
			case fourth:
				p.piece = T_three;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.third;
				break;
			default:
				break;
			}
		case Z:
			switch (rotation) {
			case first:
				p.piece = Z_two;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.fourth;
				break;
			case secound:
				p.piece = Z_one;
				p.rotationPoint = new Point(1, 1);
				p.rotation = Rotation_time.first;
				break;
			case third:
				p.piece = Z_two;
				p.rotationPoint = new Point(1, 0);
				p.rotation = Rotation_time.secound;
				break;
			case fourth:
				p.piece = Z_one;
				p.rotationPoint = new Point(0, 1);
				p.rotation = Rotation_time.third;
				break;
			default:
				break;
			}
		}
		return this;
	
	}

	@Override
	public Point getRotationPoint() {
		return rotationPoint;
	}

	@Override
	public PieceType getPieceType() {
		return pieceType;
	}

	@Override
	public Piece clone() {
		Piece newPiece = null;
		newPiece = new MyPiece(pieceType, this.rotation);

		return newPiece;
	}

}
