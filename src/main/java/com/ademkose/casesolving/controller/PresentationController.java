package com.ademkose.casesolving.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ademkose.casesolving.exception.BadRequestException;
import com.ademkose.casesolving.model.Presentation;
import com.ademkose.casesolving.service.PresentationService;

@Controller
@Slf4j
public class PresentationController {

  public static final String PRESENTATION_LIST = "presentation_list";
  public static final String REDIRECT_PRESENTATION = "redirect:/presentation/";
  @Autowired
  PresentationService presentationService;

  @GetMapping("/presentation")
  public String presentationForm(Model model) {
    model.addAttribute("presentation", new Presentation());
    model.addAttribute(PRESENTATION_LIST, presentationService.getAllPresentation());
    log.info("[presentationForm]: Getting the presentation...");
    return "presentation";
  }

  @GetMapping("/tracks")
  public String viewResult(Model model) {
    List<Presentation> newPresentationList = presentationService.startToMakeTracks();
    model.addAttribute("tracks_list", newPresentationList);
    log.info("[viewResult]: Listing tracks...");
    return "tracks";
  }

  @GetMapping("/load_test_data")
  public String loadTestData(Model model, RedirectAttributes redirAttrs) {
    presentationService.loadTestData();
    redirAttrs.addFlashAttribute("success",
        "The test presentations have been successfully added to database...");
    log.info("[loadTestData]: The test presentations have been successfully added to database... ");
    return REDIRECT_PRESENTATION;
  }

  @PostMapping("/presentation")
  public String presentationSubmit(@ModelAttribute Presentation presentation, Model model,
      RedirectAttributes redirectAttributes) {

    log.info("[presentationSubmit]: Getting new presentation {} ", presentation);
    try {
      presentationService.saveThePresentation(presentation);
      model.addAttribute(PRESENTATION_LIST, presentationService.getAllPresentation());
    } catch (BadRequestException e) {
      model.addAttribute(PRESENTATION_LIST, presentationService.getAllPresentation());
      redirectAttributes.addFlashAttribute("error", e.getMessage());
      log.info("[presentationSubmit]: Error {} - {}", e.getMessage(), presentation);
      return REDIRECT_PRESENTATION;
    }
    log.info("[presentationSubmit]: The presentation has been successfully added to database... {}"
        , presentation);
    redirectAttributes.addFlashAttribute("success",
        "The presentation has been successfully added to database...");
    return REDIRECT_PRESENTATION;
  }
  @PostMapping("/request")
  public @ResponseBody ResponseEntity<String> presentationSubmit(@RequestBody Presentation presentation) {

    log.info("[presentationSubmit]: Getting new presentation {} ", presentation);
    try {
      presentationService.saveThePresentation(presentation);
    } catch (BadRequestException e) {
      log.info("[presentationSubmit]: Error {} - {}", e.getMessage(), presentation);
      return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST) ;
    }
    log.info("[presentationSubmit]: The presentation has been successfully added to database... {}"
        , presentation);
    return new ResponseEntity<>(HttpStatus.OK.name(),HttpStatus.OK) ;
  }
}