public class Q2 {
    public boolean visited; // true if node has been visited
    public List neighbors; // list of Nodes that are directly
    // connected to this Node

    /** Return the number of nodes that can be directly or
    * indirectly reached from node n. The original starting
    * node should also be counted once. */
    public int nNeighbors(Node n) {
        //Enter your code here

        //base case
        if(n.visited){
            return 0;
        }
        //then look into neighbors
        else{
            n.visited = true;
            Iterator iter = n.neighbors.iterator();

            int ret = 1;
            while(iter.hasNext()){
                ret += nNeighbors((Q2) iter.next());
            }
            return ret;
        }
    }
}
