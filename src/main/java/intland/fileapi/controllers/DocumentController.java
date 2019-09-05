package main.java.intland.fileapi.controllers;

import main.java.intland.fileapi.interfaces.IDocumentService;
import main.java.intland.fileapi.models.DocumentBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DocumentController {

	@Autowired
    private IDocumentService documentService;
	
    @GetMapping("/document")
    public DocumentBatch getDocumentBatch(@RequestParam(value="skip", required = true) int skip, @RequestParam(value="take", required = true) int take) {
        return documentService.getDocumentBatch(skip, take);
    }
}
