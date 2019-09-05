package main.java.intland.fileapi.models;

public class DocumentBatch {
	
    private final String content;
    private final int remainingParagraphs;

    public DocumentBatch(String content, int remainingParagraphs) {
        this.content = content;
        this.remainingParagraphs = remainingParagraphs;
    }

    public int getRemainingParagraphs() {
        return remainingParagraphs;
    }

    public String getContent() {
        return content;
    }
}