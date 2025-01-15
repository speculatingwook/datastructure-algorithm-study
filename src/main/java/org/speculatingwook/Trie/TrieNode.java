package org.speculatingwook.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isEndOfWord;
    private int count;  // 이 노드를 지나는 단어의 수

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        count = 0;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public void decrementCount() {
        count--;
    }
}