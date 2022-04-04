package com.canidium.training

class ChessBoard {


    LinkedHashMap board;

   ChessBoard ()
   {
        this.board = new LinkedHashMap(8)
   }


    String toString() {
        def String brdStr = ""
        def ColorPiece piece = null
        def int v_ascii_a =97
        def char v_columnName = (char)(v_ascii_a)
        def String s_columnName = (String) v_columnName

        brdStr += "  a  b  c  d  e  f  g  h \n";
        for (int r = 0; r < 8; r++) {
            brdStr += (8 - r) + " "
            for (int c = 0; c < 8; c++) {
                v_columnName =(char)(v_ascii_a+c)
                s_columnName =(String) v_columnName
                piece = this.getPiece ( s_columnName,8-r)
                if ( piece != null) {
                    brdStr += piece.getSmallColor()
                    brdStr += piece.getSmallPiece()
                    brdStr += "."
                }
                else {
                   brdStr += "  ."
                }
            }
            brdStr += "\n" // line break
        }
        return brdStr
    }


    void addPiece ( ColorPiece piece , String boardColumn, int boardRow) {

       LinkedHashMap rowMap= this.board.get (boardColumn)
       if (rowMap != null) {
           ColorPiece currentPiece = rowMap.get(boardRow)
           if (currentPiece != null) {
               rowMap.remove(boardRow)
               rowMap.put(boardRow, piece)
           }
           else {
               rowMap.put(boardRow, piece)
           }
       }
       else {
           rowMap = new LinkedHashMap(8)
           rowMap.put(boardRow, piece)
           this.board.put(boardColumn, rowMap)
       }

   }

    void setInitialPosition ( ) {
        def colorPieceWK = new ColorPiece(ColorPiece.Color.WHITE, ColorPiece.Piece.KING)
        def colorPieceWQ = new ColorPiece(ColorPiece.Color.WHITE, ColorPiece.Piece.QUEEN)
        def colorPieceWB = new ColorPiece(ColorPiece.Color.WHITE, ColorPiece.Piece.BISHOP)
        def colorPieceWN = new ColorPiece(ColorPiece.Color.WHITE, ColorPiece.Piece.KNIGHT)
        def colorPieceWR = new ColorPiece(ColorPiece.Color.WHITE, ColorPiece.Piece.ROOK)
        def colorPieceWP = new ColorPiece(ColorPiece.Color.WHITE, ColorPiece.Piece.PAWN)

        def colorPieceBK = new ColorPiece(ColorPiece.Color.BLACK, ColorPiece.Piece.KING)
        def colorPieceBQ = new ColorPiece(ColorPiece.Color.BLACK, ColorPiece.Piece.QUEEN)
        def colorPieceBB = new ColorPiece(ColorPiece.Color.BLACK, ColorPiece.Piece.BISHOP)
        def colorPieceBN = new ColorPiece(ColorPiece.Color.BLACK, ColorPiece.Piece.KNIGHT)
        def colorPieceBR = new ColorPiece(ColorPiece.Color.BLACK, ColorPiece.Piece.ROOK)
        def colorPieceBP = new ColorPiece(ColorPiece.Color.BLACK, ColorPiece.Piece.PAWN)

        // Initial position
        this.addPiece( colorPieceWK , 'e', 1)
        this.addPiece( colorPieceWQ , 'd', 1)
        this.addPiece( colorPieceWR , 'a', 1)
        this.addPiece( colorPieceWR , 'h', 1)
        this.addPiece( colorPieceWN , 'b', 1)
        this.addPiece( colorPieceWN , 'g', 1)
        this.addPiece( colorPieceWB , 'c', 1)
        this.addPiece( colorPieceWB , 'f', 1)
        this.addPiece( colorPieceWP , 'e', 2)
        this.addPiece( colorPieceWP , 'd', 2)
        this.addPiece( colorPieceWP , 'a', 2)
        this.addPiece( colorPieceWP , 'h', 2)
        this.addPiece( colorPieceWP , 'b', 2)
        this.addPiece( colorPieceWP , 'g', 2)
        this.addPiece( colorPieceWP , 'c', 2)
        this.addPiece( colorPieceWP , 'f', 2)
        // Black pieces
        this.addPiece( colorPieceBK , 'e', 8)
        this.addPiece( colorPieceBQ , 'd', 8)
        this.addPiece( colorPieceBR , 'a', 8)
        this.addPiece( colorPieceBR , 'h', 8)
        this.addPiece( colorPieceBN , 'b', 8)
        this.addPiece( colorPieceBN , 'g', 8)
        this.addPiece( colorPieceBB , 'c', 8)
        this.addPiece( colorPieceBB , 'f', 8)
        this.addPiece( colorPieceBP , 'e', 7)
        this.addPiece( colorPieceBP , 'd', 7)
        this.addPiece( colorPieceBP , 'a', 7)
        this.addPiece( colorPieceBP , 'h', 7)
        this.addPiece( colorPieceBP , 'b', 7)
        this.addPiece( colorPieceBP , 'g', 7)
        this.addPiece( colorPieceBP , 'c', 7)
        this.addPiece( colorPieceBP , 'f', 7)

    }

   void showBoard (  boolean onlyGraphic) {
       if ( !onlyGraphic ) {
        this.board.each { k, v ->
            v.each { kRow, vRow ->
                println "$k$kRow : $vRow.color $vRow.piece "
            }
         }
        println()
       }
       println(this)
    }

    ColorPiece getPiece ( String column , int boardRow ) {
        return this.board?[column]?[boardRow]
    }


    void movePiece ( String column , int boardRow,  String toColumn , int toBoardRow   ) {


        print "Moving " + column +boardRow+" to "+ toColumn + toBoardRow

        LinkedHashMap originRow = this.board.get(column)
        LinkedHashMap destRow = this.board.get(toColumn)

        ColorPiece whichPiece = originRow.get(boardRow)
        ColorPiece wherePiece = destRow.get(toBoardRow)

        if (whichPiece != null)
        {
            if (wherePiece != null) // there are pieces on origin and destiny
            {
                destRow.remove(toBoardRow)
                destRow.put(toBoardRow, whichPiece)
                originRow.remove(boardRow)
            }
            else  // there is a piece only on origin
            {
                destRow.put(toBoardRow, whichPiece)
                originRow.remove(boardRow)
            }
        }
        else {
            println "Illegal Move"
        }
    }

}
