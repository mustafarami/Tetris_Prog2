package tetris.game.pieces;

//import static org.junit.Assert.assertNotNull;

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
		setPiece(pt, rot);
	}

	public void setPiece(PieceType pt, Rotation_time rot) {
		Rotation_time rotation = rot;
		pieceType = pt;
		switch (pt) {
		case I:
			switch (rotation) {
			case first:
				this.piece = I_one;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.first;
				break;
			case secound:
				this.piece = I_two;
				this.rotationPoint = new Point(0, 2);
				this.rotation = Rotation_time.secound;
				break;
			case third:
				this.piece = I_one;
				this.rotationPoint = new Point(2, 0);
				this.rotation = Rotation_time.third;
				break;
			case fourth:
				this.piece = I_two;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.fourth;
				break;
			default:
				break;
			}
			break;
		case J:
			switch (rotation) {
			case first:
				this.piece = J_one;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.first;
				break;
			case secound:
				this.piece = J_two;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.secound;
				break;
			case third:
				this.piece = J_three;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.third;
				break;
			case fourth:
				this.piece = J_four;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.fourth;
				break;
			default:
				break;
			}
			break;
		case L:
			switch (rotation) {
			case first:
				this.piece = L_one;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.first;
				break;
			case secound:
				this.piece = L_two;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.secound;
				break;
			case third:
				this.piece = L_three;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.third;
				break;
			case fourth:
				this.piece = L_four;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.fourth;
				break;
			default:
				break;
			}
			break;
		case O:
			switch (rotation) {
			case first:
				this.piece = O_one;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.first;
				break;
			case secound:
				this.piece = O_one;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.secound;
				break;
			case third:
				this.piece = O_one;
				this.rotationPoint = new Point(0, 0);
				this.rotation = Rotation_time.third;
				break;
			case fourth:
				this.piece = O_one;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.first;
				break;
			default:
				break;
			}
			break;
		case S:
			switch (rotation) {
			case first:
				this.piece = S_one;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.first;
				break;
			case secound:
				this.piece = S_two;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.secound;
				break;
			case third:
				this.piece = S_one;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.third;
				break;
			case fourth:
				this.piece = S_two;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.fourth;
				break;
			default:
				break;
			}
			break;
		case T:
			switch (rotation) {
			case first:
				this.piece = T_one;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.first;
				break;
			case secound:
				this.piece = T_tow;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.secound;
				break;
			case third:
				this.piece = T_three;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.third;
				break;
			case fourth:
				this.piece = T_four;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.fourth;
				break;
			default:
				break;
			}
			break;
		case Z:
			switch (rotation) {
			case first:
				this.piece = Z_one;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.first;
				break;
			case secound:
				this.piece = Z_two;
				this.rotationPoint = new Point(1, 0);
				this.rotation = Rotation_time.secound;
				break;
			case third:
				this.piece = Z_one;
				this.rotationPoint = new Point(0, 1);
				this.rotation = Rotation_time.third;
				break;
			case fourth:
				this.piece = Z_two;
				this.rotationPoint = new Point(1, 1);
				this.rotation = Rotation_time.fourth;
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
		boolean [][] co = new boolean[getHeight()][];
		for(int i =0; i < getHeight(); i++) {
			co[i]=this.piece[i].clone();
		}
		return co;
	}

	@Override
	public Piece getClockwiseRotation() {
//		if (this.rotation == Rotation_time.first) {
//			MyPiece p = new MyPiece(pieceType, Rotation_time.secound);
//			return p;
//		} else if (this.rotation == Rotation_time.secound) {
//			MyPiece p = new MyPiece(pieceType, Rotation_time.third);
//			return p;
//		} else if (this.rotation == Rotation_time.third) {
//			MyPiece p = new MyPiece(pieceType, Rotation_time.fourth);
//			return p;
//		} else if (this.rotation == Rotation_time.fourth){
//			MyPiece p = new MyPiece(pieceType, Rotation_time.first);
//			return p;
//		} else {return null;}

		switch (this.rotation) {
		case first:
			return new MyPiece(pieceType, Rotation_time.secound);
		case secound:
			return new MyPiece(pieceType, Rotation_time.third);
//			pi = new MyPiece(pieceType, Rotation_time.third);
			
		case third:
			return new MyPiece(pieceType, Rotation_time.fourth);
//			pi = new MyPiece(pieceType, Rotation_time.fourth);
			
		case fourth:
			return new MyPiece(pieceType, Rotation_time.first);
//			pi = new MyPiece(pieceType, Rotation_time.first);
			
		default:
			break;
		}
		return null;

	}

	@Override
	public Piece getCounterClockwiseRotation() {

//		MyPiece pi = null;
		switch (this.rotation) {
		case first:
			return new MyPiece(pieceType, Rotation_time.fourth);
//			pi = new MyPiece(pieceType, Rotation_time.fourth);
//			break;
		case secound:
			return new MyPiece(pieceType, Rotation_time.first);
//			pi = new MyPiece(pieceType, Rotation_time.first);
//			break;
		case third:
			return new MyPiece(pieceType, Rotation_time.secound);
//			pi = new MyPiece(pieceType, Rotation_time.secound);
//			break;
		case fourth:
			return new MyPiece(pieceType, Rotation_time.third);
//			pi = new MyPiece(pieceType, Rotation_time.third);
//			break;
		default:
			break;
		}
		return null;

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

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Piece) {
			Piece p = (Piece) obj;
			if (!(p.getPieceType().equals(this.getPieceType()))) {
				return false;
			}
			System.out.println(this.getHeight() + " " + p.getHeight());

			if(this.getHeight() != p.getHeight() || this.getWidth() != p.getWidth()) {
			return false;
			}
			
			for(int i = 0; i < this.getHeight(); i ++) {
				for(int j = 0; j < this.getWidth(); j ++) {
					if(this.getBody()[i][j] != p.getBody()[i][j]) {
						return false;
					}
				}
			}
			
			

			if (!p.getRotationPoint().equals(this.getRotationPoint())) {
				return false;
			}

//			if (p.rotation.equals(this.rotation)) {
//				return true;
//			}
			return true;
		} 
			return false;
	}

}
