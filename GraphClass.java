package p11_Package;

/**
 * Simple class for managing vertices and edges
 * in a graph
 *
 * @author Zane Fink
 */
public class GraphClass
{
    /**
     * default vertex capacity
     * <p>
     * Note: Limited to number of upper case letters in alphabet
     */
    private final int VERTEX_CAPACITY = 26;

    /**
     * indication of vertex not in list
     */
    private final int NOT_IN_LIST = -1;

    /**
     * constant space character
     *
     */
    private final char SPACE = ' ';

    /**
     * constant dash character
     *
     */
    private final char DASH = '-';

    /**
     * size of vertex array
     */
    private int vertexListSize;

    /**
     * array of vertices
     */
    VertexNode[] vertexList;

    /**
     * Default Constructor
     */
    public GraphClass()
    {
       vertexList = new VertexNode[ VERTEX_CAPACITY ];

       vertexListSize = 0;
    }

    /**
     * Sets vertex with adjacency
     *
     * <p>Note: Adds new vertex as needed, otherwise adds adjacent
     * vertex and weight to existing vertex
     *
     * <p>Note: Adds vertices in both directions (e.g., A with B as
     * adjacency, and B with A as adjacency )
     *
     * <p> Uses insertVertex to minimize excessive coding
     * @param vertex character vertex letter
     * @param adjVertex character adjacent vertex letter
     * @param weight integer weight between vertices
     * @return boolean result of action
     * false if vertex array is full, true otherwise
     */
    public boolean setVertex( char vertex, char adjVertex, int weight )
    {
        int vertexIndex = vertexInList( vertex );

        if( vertexIndex != NOT_IN_LIST )
        {
           vertexList[ vertexIndex ].addAdjacentVertex( adjVertex, weight );
           return true;
        }

        return insertVertex( vertex, adjVertex, weight );
    }


    /**
     * Inserts vertex, adjacent vertex, and weight
     * into array alphabetically
     * @param vertex character vertex letter
     * @param adjVertex character adjacent vertex letter
     * @param weight integer weight between vertices
     * @return result of insertion, false if
     * vertex array is full, true otherwise
     */
    public boolean insertVertex( char vertex, char adjVertex, int weight )
    {
        int searchIndex = 0;
        int foundIndex;

        if( vertexListSize == VERTEX_CAPACITY )
        {
            return false;
        }

        if( vertexListSize == 0 )
        {
            searchIndex = 0;
        }
        else
        {
            while ( vertexList[ searchIndex ] != null &&
                    vertexList[ searchIndex ].getVertex() < vertex )
            {
                searchIndex++;
            }

            for (foundIndex = vertexListSize - 1; foundIndex >= searchIndex; foundIndex--)
            {
                vertexList[ foundIndex + 1 ] = vertexList[ foundIndex ];
            }
        }

        vertexListSize++;
        vertexList[ searchIndex ] = new VertexNode( vertex, adjVertex, weight );

        vertexList[ searchIndex ].addAdjacentVertex( adjVertex, weight );

        return true;
    }

    /**
     * Tests for vertex in list
     * @param testVertex character vertex to search for
     * @return integer index if vertex found, constant
     * NOT_IN_LIST otherwise
     */
    public int vertexInList( char testVertex )
    {
        int index;
        for( index = 0; index < vertexListSize; index++ )
        {
            if( vertexList[ index ].getVertex() == testVertex )
            {
                return index;
            }
        }

        return NOT_IN_LIST; // temporary stub return
    }

    /**
     * Breadth-first search (BFS) is actually
     * just a traversal
     * @param startVertex character vertex to start with
     * @param showQueue boolean flag to control display
     *                  of queue during operations
     * @return String result fo traversal process
     * showing each visited vertex in the order it was visited
     */
    public String BFS( char startVertex, boolean showQueue )
    {

        // TODO: Implement this method

        return ""; // temporary stub return
    }

    /**
     * Depth-First Search (DFS)
     * is actually a treversal
     * @param startVertex character vertex to start with
     * @param showQueue boolean flag to control display of stack during operations
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String DFS( char startVertex, boolean showQueue )
    {
       // TODO: Implement this method

       return ""; // temporary stub return
    }

    /**
     * Generates an adjacency matrix table that displays
     * weights between vertices
     */
    public void generateAdjacencyMatrix()
    {
       // TODO: Implement this method
    }

    private void printChars( int numChars, char outChar )
    {
        if( numChars > 0 )
        {
            System.out.print( outChar );

            printChars( numChars - 1, outChar );
        }
    }

    public String toString()
    {
        String returnString = "";
        for( int index = 0; index < vertexListSize; index++ )
        {
           returnString += vertexList[ index ].getVertex() + " ";
        }
        return  returnString;
    }
}
