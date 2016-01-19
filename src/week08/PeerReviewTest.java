package week08;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by georgipavlov on 19.01.16.
 */
public class PeerReviewTest {

    PeerReview peer;
    List<Integer> list;

    @Before
    public void makeClass(){
        peer = new PeerReview();
        list = new ArrayList<>();
    }

    @Test
    public void testSnuffle() throws Exception {
        peer.setCountOfNames(30);
        list = peer.snuffle(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        assertEquals(30,list.size());
    }
}