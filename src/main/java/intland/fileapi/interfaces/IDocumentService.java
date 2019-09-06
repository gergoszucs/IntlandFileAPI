package intland.fileapi.interfaces;

import intland.fileapi.models.DocumentBatch;

public interface IDocumentService {
	public abstract DocumentBatch getDocumentBatch(int skip, int take);
}
