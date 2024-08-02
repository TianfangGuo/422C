public static void testFromBook()
{
    RedBlackTree t = new RedBlackTree();
    t.add("A");
    t.add("B");
    t.add("C");
    t.add("d");
    t.add("E");
    assertEquals("A B C d E" , t.toString());
}