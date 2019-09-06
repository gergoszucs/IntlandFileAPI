package intland.fileapi.services;

import org.springframework.stereotype.Service;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import intland.fileapi.interfaces.IDocumentService;
import intland.fileapi.models.DocumentBatch;

@Service
public class DocumentService implements IDocumentService {
	// The document itself should be fetched from a remote storage
	// Now we just store an arbitrary length and generate its content randomly
	private int documentLength = 1000000;
	Lorem lorem = LoremIpsum.getInstance();

	@Override
	public DocumentBatch getDocumentBatch(int skip, int take) {
		int remainingParagraphs = documentLength - (skip + take);
		
		return new DocumentBatch(generateRandomParagraphs(skip, take), remainingParagraphs > 0 ? remainingParagraphs : 0);
	}

	private String[] generateRandomParagraphs(int existingParagraphs, int paragraphsToGenerate) {
		String[] paragraphs = new String[paragraphsToGenerate];
		
		for(int i=0; i<paragraphsToGenerate; i++) {
			int paragraphIndex = existingParagraphs + i + 1;
			paragraphs[i] = "<p>" + paragraphIndex + " lorem ipsum<p>";
		}
		
		return paragraphs;
	}
}
