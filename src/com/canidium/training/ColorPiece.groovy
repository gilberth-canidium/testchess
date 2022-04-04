package com.canidium.training

class ColorPiece {

    enum Color {     WHITE, BLACK  }
    enum Piece { PAWN, BISHOP, KNIGHT, ROOK, QUEEN, KING }

    Color color
    Piece piece
    ColorPiece ( Color color , Piece piece ) {
            this.color = color
            this.piece = piece
    }

    String getSmallColor ( )
    {
        return ((String) this.color).substring(0,1)
    }
    String getSmallPiece ( )
    {
        if (this.piece == Piece.KNIGHT )
           return 'N'
        else
          return ((String) this.piece).substring(0,1)
    }
}
