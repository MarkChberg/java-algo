package basic5;

import basic2.Node;

import java.math.BigInteger;
import java.util.Objects;

public class MyHashTable {
    Node[] infos;

    public MyHashTable() {
        this.infos = new Node[100];
    }

    public int hashCode(String key) {
        char[] chars = key.toCharArray();
        BigInteger m37 = new BigInteger("1");
        BigInteger hash = new BigInteger("0");
        for (char aChar : chars) {
            int charNum = aChar - 96;
            hash = hash.add(new BigInteger("" + charNum).multiply(m37));
            m37 = m37.multiply(new BigInteger("37"));
        }
        return hash.mod(new BigInteger("" + infos.length)).intValue();
    }

    public void insert(Info info) {
        Node<Info> node = new Node<>(info);
        int hashCode = hashCode(info.key);
        if (infos[hashCode] == null) {
            infos[hashCode] = node;
        } else {
            Node<Info> current = infos[hashCode];
            while(current.next != null) {
                if (current.date.key.equals(info.key)) {
                    current.date = info;
                    break;
                }
                current = current.next;
            }
            current.next = node;
        }
    }

    public Info findInfo(String key) {
        int hashCode = hashCode(key);
        Node<Info> current = infos[hashCode];
        while(!Objects.equals(key,current.date.key)) {
             current = current.next;
             if (current == null) {
                 return null;
             }
        }
        return current.date;
    }
}
