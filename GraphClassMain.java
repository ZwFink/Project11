package p11_Package;

public class GraphClassMain
{
    public static void main( String[] args )
    {
        GraphClass gc = new GraphClass();
        gc.setVertex( 'A', 'D', 1 );
        gc.setVertex( 'A', 'B', 1 );
        gc.setVertex( 'D', 'C', 1 );
        gc.setVertex( 'C', 'R', 1 );
        gc.setVertex( 'B', 'C', 1 );
        gc.setVertex( 'R', 'O', 1 );
        gc.setVertex( 'B', 'F', 1 );

        gc.generateAdjacencyMatrix();

        System.out.println( gc.BFS( 'A', true ) );
    }
}
