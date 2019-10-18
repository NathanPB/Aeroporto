package br.upf.ads.aeroporto.utils;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DOMUtils {
    public static Stream<Node> toStream(NodeList nodeList) {
        return IntStream.range(0, nodeList.getLength()).mapToObj(nodeList::item);
    }
}
