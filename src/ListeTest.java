import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest
{
    Liste fyldtListe = new Liste("hold da lige op mand hvor er her meget text");
    Liste tomList = new Liste();
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

    @Test
    void smartconstructor()
    {
        Liste liste1 = new Liste("det er smart det her");
        Liste liste2 = new Liste("palle");

        assertEquals("det er smart det her", liste1.printFromTail());
        assertEquals("palle", liste2.printFromTail());

    }

    @Test
    void smatindsæt_head()
    {
        assertEquals("hej",tomList.insertFromhead("hej").data);
        assertEquals("med",tomList.insertFromhead("med").data);
        tomList.insertFromhead("dig");
        assertEquals("hej med dig", tomList.printFromTail());

    }

    @Test
    void smartInsertFromTail()
    {
        assertEquals("hej", tomList.insetFromTail("hej").data);
        assertEquals("med",tomList.insetFromTail("med").data);
        tomList.insetFromTail("dig");
        assertEquals("hej med dig", tomList.printFromHead());

    }

    @Test
    void findeNode()
    {
        assertEquals(null, tomList.findeNode("palle"));

        assertEquals("op", fyldtListe.findeNode("op").data);


    }

    @Test
    void removeNodeFromHead()
    {

        assertEquals(null, tomList.removeFromHead());
        tomList.insetFromTail("hej");
        assertEquals("hej", tomList.removeFromHead().data);
        assertEquals(true, tomList.isEmpty());

        // "hold da lige op mand hvor er her meget text"

            assertEquals("text", fyldtListe.removeFromHead().data);
            assertEquals("hold da lige op mand hvor er her meget", fyldtListe.printFromTail());

    }

    @Test
    void removeFromTail()
    {
        assertEquals(null, tomList.removeFromTail());

        tomList.insetFromTail("hej");
        assertEquals("hej", tomList.removeFromTail().data);
        assertEquals(true, tomList.isEmpty());


        fyldtListe.removeFromTail();
        assertEquals("da lige op mand hvor er her meget text", fyldtListe.printFromTail());



    }

    @Test
    void removeNode()
    {
        assertEquals(null, tomList.removeNode("op"));

        //"hold da lige op mand hvor er her meget text"
        assertEquals("mand", fyldtListe.removeNode("mand").data);
        assertEquals("hold da lige op hvor er her meget text", fyldtListe.printFromTail());
        assertEquals("hold", fyldtListe.removeNode("hold").data);
        assertEquals("da lige op hvor er her meget text",fyldtListe.printFromTail());

        assertEquals("text", fyldtListe.removeNode("text").data);
        assertEquals("da lige op hvor er her meget",fyldtListe.printFromTail());


    }
}