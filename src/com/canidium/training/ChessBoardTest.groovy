package com.canidium.training

class ChessBoardTest {
    static void main(String[] args) {
        def colorPiece1
        colorPiece1 = new ColorPiece(ColorPiece.Color.WHITE, ColorPiece.Piece.KING)
        def colorPiece2 = new ColorPiece ( ColorPiece.Color.WHITE, ColorPiece.Piece.PAWN )
        def colorPiece3 = new ColorPiece ( ColorPiece.Color.BLACK, ColorPiece.Piece.ROOK )
        def colorPiece4 = new ColorPiece ( ColorPiece.Color.BLACK, ColorPiece.Piece.KING )

        def theBoard = new ChessBoard()

        theBoard.setInitialPosition()

        theBoard.showBoard(true)

        println " "
        theBoard.movePiece('e', 2 , 'e', 4)
        print " "
        theBoard.movePiece('e', 7 , 'e', 5)
        print " "
        theBoard.movePiece('g', 1 , 'f', 3)
        print " "
        theBoard.movePiece('b', 8 , 'c', 6)
        print " "
        theBoard.movePiece('f', 1 , 'c', 4)
        println " "

        theBoard.showBoard(true)

    }

}
