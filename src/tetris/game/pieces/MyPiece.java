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
		Rotation_time rotation = rot;
		switch (pt) {
		case I:
			switch (rotation) {
			case first:
				this.piece = I_one;
				this.rotationPoint = new Point(1, 02);
				this.rotation = Rotation_time.first;
				break;
			case secound:
				this.piece = I_two;
				this.rotationPoint = new Point(2, 0);
				this.rotation = Rotation_time.third;
				break;
			case third:
				this.piece = I_two;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.fourth;
				break;
			case fourth:
				this.piece = I_one;
				this.rotationPoint = new Point(0, 2);

				this.rotation = Rotation_time.first;

				break;
			default:
				break;
			}
		case J:
			switch (rotation) {
			case first:
				this.piece = J_two;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.secound;
				break;
			case secound:
				this.piece = J_three;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.third;
				break;
			case third:
				this.piece = J_four;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.fourth;
				break;
			case fourth:
				this.piece = J_one;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		case L:
			switch (rotation) {
			case first:
				this.piece = L_two;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.secound;
				break;
			case secound:
				this.piece = L_three;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.third;
				break;
			case third:
				this.piece = L_four;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.fourth;
				break;
			case fourth:
				this.piece = L_one;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.first;
				break;
			default:
				break;
			}

		case O:
			switch (rotation) {
			case first:
				this.piece = O_one;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.secound;
				break;
			case secound:
				this.piece = O_one;
				this.rotationPoint = new Point(0, 0);
				this.rotation = Rotation_time.third;
				break;
			case third:
				this.piece = O_one;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.fourth;
				break;
			case fourth:
				this.piece = O_one;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		case S:
			switch (rotation) {
			case first:
				this.piece = S_two;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.secound;
				break;
			case secound:
				this.piece = S_one;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.third;
				break;
			case third:
				this.piece = S_two;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.fourth;
				break;
			case fourth:
				this.piece = S_one;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		case T:
			switch (rotation) {
			case first:
				this.piece = T_tow;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.secound;
				break;
			case secound:
				this.piece = T_three;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.third;
				break;
			case third:
				this.piece = T_four;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.fourth;
				break;
			case fourth:
				this.piece = T_one;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		case Z:
			switch (rotation) {
			case first:
				this.piece = Z_two;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.secound;
				break;
			case secound:
				this.piece = Z_one;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.third;
				break;
			case third:
				this.piece = Z_two;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.fourth;
				break;
			case fourth:
				this.piece = Z_one;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
		default:
			break;
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
		if(this.rotation == Rotation_time.first) {
		MyPiece p = new MyPiece(pieceType, Rotation_time.secound);
				return p;
		}else if(this.rotation == Rotation_time.secound) {
			MyPiece p = new MyPiece(pieceType, Rotation_time.third);
			return p;
		} else if(this.rotation == Rotation_time.third) {
			MyPiece p = new MyPiece(pieceType, Rotation_time.fourth);
			return p;
		} else { MyPiece p = new MyPiece(pieceType, Rotation_time.first);
		return p;
		}
		
	}

	@Override
	public Piece getCounterClockwiseRotation() {
//		MyPiece p = new MyPiece(pieceType, rotation);
//		switch (pieceType) {
//		case I:
//			switch (rotation) {
//			case first:
//				p.piece = I_two;
//				p.rotationPoint = new Point(0, 1);
//				p.rotation = Rotation_time.fourth;
//				break;
//			case secound:
//				p.piece = I_one;
//				p.rotationPoint = new Point(1, 0);
//				p.rotation = Rotation_time.first;
//				break;
//			case third:
//				p.piece = I_two;
//				p.rotationPoint = new Point(0, 2);
//				p.rotation = Rotation_time.secound;
//				break;
//			case fourth:
//				p.piece = I_one;
//				p.rotationPoint = new Point(2, 0);
//				p.rotation = Rotation_time.third;
//				break;
//			default:
//				break;
//			}
//		case J:
//			switch (rotation) {
//			case first:
//				p.piece = J_four;
//				p.rotationPoint = new Point(0, 1);
//				p.rotation = Rotation_time.fourth;
//				break;
//			case secound:
//				p.piece = J_one;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.first;
//				break;
//			case third:
//				p.piece = J_two;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.secound;
//				break;
//			case fourth:
//				p.piece = J_three;
//				p.rotationPoint = new Point(1, 0);
//				p.rotation = Rotation_time.third;
//				break;
//			default:
//				break;
//			}
//		case L:
//			switch (rotation) {
//			case first:
//				p.piece = L_four;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.fourth;
//				break;
//			case secound:
//				p.piece = L_one;
//				p.rotationPoint = new Point(1, 0);
//				p.rotation = Rotation_time.first;
//				break;
//			case third:
//				p.piece = L_two;
//				p.rotationPoint = new Point(0, 1);
//				p.rotation = Rotation_time.secound;
//				break;
//			case fourth:
//				p.piece = L_three;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.third;
//				break;
//			default:
//				break;
//			}
//
//		case O:
//			switch (rotation) {
//			case first:
//				p.piece = O_one;
//				p.rotationPoint = new Point(0, 1);
//				p.rotation = Rotation_time.fourth;
//				break;
//			case secound:
//				p.piece = O_one;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.first;
//				break;
//			case third:
//				p.piece = O_one;
//				p.rotationPoint = new Point(1, 0);
//				p.rotation = Rotation_time.secound;
//				break;
//			case fourth:
//				p.piece = O_one;
//				p.rotationPoint = new Point(0, 0);
//				p.rotation = Rotation_time.third;
//				break;
//			default:
//				break;
//			}
//		case S:
//			switch (rotation) {
//			case first:
//				p.piece = S_two;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.fourth;
//				break;
//			case secound:
//				p.piece = S_one;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.first;
//				break;
//			case third:
//				p.piece = S_two;
//				p.rotationPoint = new Point(1, 0);
//				p.rotation = Rotation_time.secound;
//				break;
//			case fourth:
//				p.piece = S_one;
//				p.rotationPoint = new Point(0, 1);
//				p.rotation = Rotation_time.third;
//				break;
//			default:
//				break;
//			}
//		case T:
//			switch (rotation) {
//			case first:
//				p.piece = T_four;
//				p.rotationPoint = new Point(1, 0);
//				p.rotation = Rotation_time.fourth;
//				break;
//			case secound:
//				p.piece = T_one;
//				p.rotationPoint = new Point(0, 1);
//				p.rotation = Rotation_time.first;
//				break;
//			case third:
//				p.piece = T_tow;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.secound;
//				break;
//			case fourth:
//				p.piece = T_three;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.third;
//				break;
//			default:
//				break;
//			}
//		case Z:
//			switch (rotation) {
//			case first:
//				p.piece = Z_two;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.fourth;
//				break;
//			case secound:
//				p.piece = Z_one;
//				p.rotationPoint = new Point(1, 1);
//				p.rotation = Rotation_time.first;
//				break;
//			case third:
//				p.piece = Z_two;
//				p.rotationPoint = new Point(1, 0);
//				p.rotation = Rotation_time.secound;
//				break;
//			case fourth:
//				p.piece = Z_one;
//				p.rotationPoint = new Point(0, 1);
//				p.rotation = Rotation_time.third;
//				break;
//			default:
//				break;
//			}
//		}
//		return this;
		
		if(this.rotation == Rotation_time.first) {
			MyPiece p = new MyPiece(pieceType, Rotation_time.fourth);
					return p;
			}else if(this.rotation == Rotation_time.secound) {
				MyPiece p = new MyPiece(pieceType, Rotation_time.first);
				return p;
			} else if(this.rotation == Rotation_time.third) {
				MyPiece p = new MyPiece(pieceType, Rotation_time.secound);
				return p;
			} else { MyPiece p = new MyPiece(pieceType, Rotation_time.third);
			return p;
			}
			
		
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
