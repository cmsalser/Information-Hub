package com.project.informationhub.FAQ;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
// @RequestMapping(value = "/FAQForm")
public class FAQController {

    private final FAQRepository repository;

    FAQController(FAQRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/FAQ")
    public List<FAQ> all() {
        return repository.findAll();
    }

    @PostMapping("/FAQ")
    public FAQ newFAQ(@RequestBody FAQ newFAQ) {
        return repository.save(newFAQ);
    }

    @GetMapping("/FAQ/{id}")
    public FAQ one(@PathVariable Long id) {
        return repository.findById(id)
                    .orElseThrow(() -> new FAQNotFoundException(id));
    }

    @PutMapping(value="/FAQ/{id}")
    public FAQ putMethodName(@PathVariable Long id, @RequestBody FAQ newFAQ) {
        return repository.findById(id)
                    .map(FAQ -> {
                    FAQ.setQuestion(newFAQ.getQuesiton());
                    FAQ.setAnswer(newFAQ.getAnswer());
                    return repository.save(FAQ);
                    })
                    .orElseGet(() -> {
                    newFAQ.setId(id);
                    return repository.save(newFAQ);
                    });
    }

    @DeleteMapping("/FAQ/{id}")
    public void deleteFAQ(@PathVariable Long Id) {
        repository.deleteById(Id);
    }

    // -------------------------------------------------------------------------------------------------

    // MUST IMPLEMENT DELETE AND UPDATE

    // --------------------------------------------------------------------------------------------------
    
    // @RequestMapping(method=RequestMethod.GET)
    // public String requestMethodName(Map<String, Object> model) {
    //     FAQ faq = new FAQ();
    //     model.put("FAQForm", faq);

    //     return "FAQForm";
    // }
    
}
