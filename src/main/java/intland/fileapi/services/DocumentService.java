package main.java.intland.fileapi.services;

import org.springframework.stereotype.Service;
import main.java.intland.fileapi.interfaces.IDocumentService;
import main.java.intland.fileapi.models.DocumentBatch;

@Service
public class DocumentService implements IDocumentService {
	// The document itself should be fetched from a remote storage
	// Now we just store an arbitrary length and generate its content randomly
	private int documentLength = 1000000;

	@Override
	public DocumentBatch getDocumentBatch(int skip, int take) {
		int remainingParagraphs = documentLength - (skip + take);
		
		return new DocumentBatch(generateRandomParagraphs(skip, take), remainingParagraphs > 0 ? remainingParagraphs : 0);
	}

	private String generateRandomParagraphs(int existingParagraphs, int paragraphsToGenerate) {
		String content = new String("");
		
		for(int i=1; i<=paragraphsToGenerate; i++) {
			int paragraphIndex = existingParagraphs + i;
			content += "<p>" + paragraphIndex + " lorem ipsum<p><br>";
		}
		
		return content;
	}
}
