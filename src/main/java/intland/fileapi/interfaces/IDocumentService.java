package main.java.intland.fileapi.interfaces;

import main.java.intland.fileapi.models.DocumentBatch;

public interface IDocumentService {
	public abstract DocumentBatch getDocumentBatch(int skip, int take);
}
