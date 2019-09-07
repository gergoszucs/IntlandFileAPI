package intland.fileapi.services;

import org.springframework.stereotype.Service;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import intland.fileapi.interfaces.BatchedDocumentService;
import intland.fileapi.models.DocumentBatch;

@Service
public class DocumentService implements BatchedDocumentService {
	// The document itself should be fetched from a remote storage
	// Now we just store an arbitrary length and generate its content randomly
	private int documentLength = 1000000;
	Lorem lorem = LoremIpsum.getInstance();

	@Override
	public DocumentBatch getDocumentBatch(int skip, int take) {
		int requestedParagraphs = skip + take;
		
		if(requestedParagraphs > documentLength) {
			// Disregard take, return what is left
			return new DocumentBatch(generateRandomParagraphs(documentLength - skip), 0);
		} else {
			return new DocumentBatch(generateRandomParagraphs(take), documentLength - requestedParagraphs);
		}
	}

	private String[] generateRandomParagraphs(int paragraphsToGenerate) {
		String[] paragraphs = new String[paragraphsToGenerate];
		
		for(int i=0; i<paragraphsToGenerate; i++) {
			paragraphs[i] = lorem.getHtmlParagraphs(1, 1);
		}
		
		return paragraphs;
	}
}
