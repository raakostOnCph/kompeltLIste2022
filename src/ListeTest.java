import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest
{

    Liste liste = new Liste();
    Node n = new Node("hej");
    Node n1 = new Node("med");
    Node n2 = new Node("dig");

    @org.junit.jupiter.api.Test
    void insertFromhed()
    {

        assertEquals("hej", liste.insertFromhed(n).data);
        assertEquals("med", liste.insertFromhed(n1).data);
        assertEquals("dig", liste.insertFromhed(n2).data);

        assertEquals("hej", liste.tail.data);
        assertEquals("med", liste.tail.previous.data);
        assertEquals("dig", liste.tail.previous.previous.data);


    }

    @Test
    void printfromhead()
    {
         liste.insertFromhed(n);
         liste.insertFromhed(n1);
         liste.insertFromhed(n2);

         assertEquals("dig med hej", liste.printFromHead());
    }
}