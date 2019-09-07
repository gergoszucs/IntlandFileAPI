package intland.fileapi.controllers;

import intland.fileapi.interfaces.BatchedDocumentService;
import intland.fileapi.models.DocumentBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DocumentController {

	@Autowired
    private BatchedDocumentService documentService;
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/document")
    public DocumentBatch getDocumentBatch(@RequestParam(value="skip", required = true) int skip, @RequestParam(value="take", required = true) int take) {
        return documentService.getDocumentBatch(skip, take);
    }
}
