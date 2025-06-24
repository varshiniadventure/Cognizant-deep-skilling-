import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    List<String> suggestions = new ArrayList<>();
}

class ProductTrie {
    private final TrieNode root = new TrieNode();

    public void insert(String product) {
        TrieNode node = root;
        for (char c : product.toLowerCase().toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            if (!node.suggestions.contains(product)) {
                node.suggestions.add(product);
            }
        }
        node.isEndOfWord = true;
    }

    public List<String> search(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            if (!node.children.containsKey(c)) {
                return new ArrayList<>();
            }
            node = node.children.get(c);
        }
        return node.suggestions;
    }
}

public class EcommerceSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductTrie trie = new ProductTrie();

        System.out.print("Enter number of products: ");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter product names:");
        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            trie.insert(product);
        }

        System.out.print("Enter search prefix: ");
        String prefix = scanner.nextLine();

        List<String> results = trie.search(prefix);

        if (results.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("Search results:");
            for (String product : results) {
                System.out.println("- " + product);
            }
        }

        scanner.close();
    }
}
