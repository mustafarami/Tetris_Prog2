package prog2.tests.tetris.pub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import prog2.tests.PublicTest;
import prog2.tests.tetris.TetrisExercise;
import tetris.game.Board;
import tetris.game.MyTetrisFactory;
import tetris.game.pieces.Piece;
import tetris.game.pieces.PieceFactory;

public class BoardTest implements PublicTest, TetrisExercise {

	@Rule
	public TestRule timeout = TestUtil.timeoutSeconds(5);

	Board board;
	PieceFactory pf = MyTetrisFactory.createPieceFactory(new Random());
	Piece p = pf.getJPiece();

	@Before
	public void setUp() {
		board = MyTetrisFactory.createBoard(15, 24);
	}

	@Test
	public void testAdd() throws Exception {
		board.addPiece(p, 10, 10);
		assertFalse(
				"Seems that it is not possible to add a piece to the board (canAddPiece returned true after adding)",
				board.canAddPiece(p, 10, 10));
	}

	@Test
	public void testCanAdd() throws Exception {
		assertFalse("should not be able to add piece at a wrong position", board.canAddPiece(p, -1, -1));
		assertFalse("should not be able to add piece at a wrong position", board.canAddPiece(p, 1000, 1000));
		assertFalse("should not be able to add piece at a wrong position", board.canAddPiece(p, 0, 0));
	}
	
	@Test
	public void removeRowTest() {
		
		Piece piece1 = pf.getOPiece();
		Piece piece2 = pf.getOPiece();
		Piece piece3 = pf.getOPiece();
		Piece piece4 = pf.getOPiece();
		Piece piece5 = pf.getOPiece();
		Piece piece6 = pf.getOPiece();
		Piece piece7 = pf.getOPiece();
		Piece piece8 = pf.getOPiece();
		Piece piece9 = pf.getOPiece();
		Piece piece10 = pf.getOPiece();
		Piece piece11 = pf.getOPiece();
		Piece piece12 = pf.getOPiece();
		
		board.addPiece(piece1, 14, 1);
		board.addPiece(piece2, 14, 3);
		board.addPiece(piece3, 14, 5);
		board.addPiece(piece4, 14, 7);
		board.addPiece(piece5, 14, 9);
		board.addPiece(piece6, 14, 11);
		board.addPiece(piece7, 14, 13);
		board.addPiece(piece8, 14, 15);
		board.addPiece(piece9, 14, 17);
		board.addPiece(piece10, 14, 19);
		board.addPiece(piece11, 14, 21);
		board.addPiece(piece12, 14, 23);
		
		int deletedRows = board.deleteCompleteRows();
		assertEquals(2, deletedRows);

	}
	
}
