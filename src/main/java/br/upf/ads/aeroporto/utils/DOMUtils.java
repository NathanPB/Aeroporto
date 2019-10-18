package br.upf.ads.aeroporto.utils;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DOMUtils {
    public static Stream<Node> toStream(NodeList nodeList) {
        return IntStream.range(0, nodeList.getLength()).mapToObj(nodeList::item);
    }

    public static Stream<Node> toStream(NamedNodeMap nodeMap) {
        return IntStream.range(0, nodeMap.getLength()).mapToObj(nodeMap::item);
    }

    public static Stream<Element> filterElements(Stream<Node> stream) {
        return stream.filter(it -> it instanceof Element).map(it -> (Element) it);
    }

    public static Stream<Element> toElementStream(NodeList nodeList) {
        return filterElements(toStream(nodeList));
    }
}
