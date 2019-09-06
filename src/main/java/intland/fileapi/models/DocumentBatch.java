package intland.fileapi.models;

public class DocumentBatch {

	private final String[] paragraphs;
	private final int remainingParagraphs;

	public DocumentBatch(String[] paragraphs, int remainingParagraphs) {
		this.paragraphs = paragraphs;
		this.remainingParagraphs = remainingParagraphs;
	}

	public int getRemainingParagraphs() {
		return remainingParagraphs;
	}

	public String[] getParagraphs() {
		return paragraphs;
	}
}