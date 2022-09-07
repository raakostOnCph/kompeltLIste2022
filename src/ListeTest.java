import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest
{

    Liste liste = new Liste();
    Node n = new Node("hej");
    Node n1 = new Node("med");
    Node n2 = new Node("dig");

    Node b = new Node("hej");
    Node b1 = new Node("med");
    Node b2 = new Node("dig");


    @BeforeEach
    void setUp()
    {

        liste.insertFromhead(n);
        liste.insertFromhead(n1);
        liste.insertFromhead(n2);
    }

    @org.junit.jupiter.api.Test
    void insertFromhed()
    {



        assertEquals("hej", liste.tail.data);
        assertEquals("med", liste.tail.previous.data);
        assertEquals("dig", liste.tail.previous.previous.data);


    }

    @Test
    void printfromhead()
    {


         assertEquals("dig med hej", liste.printFromHead());
    }

    @Test
    void printFromTail()
    {
        assertEquals("hej med dig", liste.printFromTail());


    }

    @Test
    void indsætbagfra()
    {

        assertEquals("hej",liste.insetFromTail(b).data );
        assertEquals("med",liste.insetFromTail(b1).data );
        assertEquals("dig",liste.insetFromTail(b2).data );

        assertEquals("dig",liste.tail.data);
        assertEquals("med",liste.tail.previous.data);
        assertEquals("hej",liste.tail.previous.previous.data);

    }
}