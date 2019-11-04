import java.util.*;

public class TextEditorImpl implements TextEditor {
    private Trie<LinkedList<Character>> userTexts;
    private Trie<ArrayDeque<String>> userStacks;

    public TextEditorImpl() {
        this.userTexts = new Trie<>();
        this.userStacks = new Trie<>();
    }

    @Override
    public void login(String username) {
        this.userTexts.insert(username, new LinkedList<>());
        this.userStacks.insert(username, new ArrayDeque<>());
    }

    @Override
    public void logout(String username) {
        this.userTexts.delete(username);
        this.userStacks.delete(username);
    }

    @Override
    public void prepend(String username, String string) {
        if (!userTexts.contains(username)) {
            return;
        }

        saveCurrentString(username);

        userTexts.getValue(username).addAll(0, createCharList(string));
    }

    @Override
    public void insert(String username, int index, String string) {
        if (!userTexts.contains(username)) {
            return;
        }

        if (index < 0 || index > length(username)) {
            return;
        }

        this.saveCurrentString(username);

        userTexts.getValue(username).addAll(index, createCharList(string));
    }

    private List<Character> createCharList(String string) {
        List<Character> charList = new ArrayList<>();
        for (char c : string.toCharArray()) {
            charList.add(c);
        }

        return charList;
    }

    @Override
    public void substring(String username, int startIndex, int length) {
        if (!userTexts.contains(username)) {
            return;
        }

        if (startIndex < 0 || startIndex + length >= length(username)) {
            return;
        }

        this.saveCurrentString(username);

        this.userTexts.insert(username,
                new LinkedList<Character>(userTexts
                        .getValue(username)
                        .subList(startIndex, startIndex + length)));
    }

    @Override
    public void delete(String username, int startIndex, int length) {
        if (!this.userTexts.contains(username)) {
            return;
        }

        if (startIndex < 0 || startIndex + length >= length(username)) {
            return;
        }

        this.saveCurrentString(username);

        this.userTexts.getValue(username).subList(startIndex, startIndex + length).clear();
    }

    @Override
    public void clear(String username) {
        if (!userTexts.contains(username)) {
            return;
        }

        this.saveCurrentString(username);

        this.userTexts.insert(username, new LinkedList<>());
    }

    @Override
    public int length(String username) {
        return getUserString(username).length();
    }

    @Override
    public String print(String username) {
        return getUserString(username);
    }

    @Override
    public void undo(String username) {
        if (!userTexts.contains(username)) {
            return;
        }

        if (userStacks.getValue(username).size() == 0) {
            return;
        }

        var lastUserString = userStacks.getValue(username).pop();

        this.saveCurrentString(username);

        this.userTexts.insert(username, new LinkedList<Character>(createCharList(lastUserString)));
    }

    @Override
    public Iterable<String> users(String prefix) {
        return userTexts.getByPrefix(prefix);
    }

    private String getUserString(String username) {
        if (!userTexts.contains(username)) {
            return "";
        }

        return userTexts.getValue(username)
                .toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "");
    }

    private void saveCurrentString(String username) {
        if (!this.userTexts.contains(username)) {
            return;
        }

        if (length(username) == 0) {
            return;
        }

        userStacks.getValue(username).push(getUserString(username));
    }
}
