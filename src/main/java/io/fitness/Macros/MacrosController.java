package io.fitness.Macros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class MacrosController {

    @Autowired
    private MacrosService macrosService;

    @RequestMapping(method= RequestMethod.PUT, value="/Macros/{id}/Recommended/{weightDesire}")
    public void setClientRecommendedMacros(@PathVariable String id, @PathVariable() String weightDesire){
        macrosService.setRecommendedMacros(id, weightDesire);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/Macros/{id}/Custom")
    public void setClientCustomMacros(@PathVariable String id, Macros macros){
        macrosService.setCustomMacros(id, macros);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/Macros/{id}/Reset")
    public void resetDailyMacros(@PathVariable String id){
        macrosService.resetMacros(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/Macros/{id}/Update")
    public void updateDailyMacros(@PathVariable String id, Macros mealMacros){
        macrosService.updateDailyMacros(id, mealMacros);
    }
    //update goal macros?
    //create a page that shows total macros left in a day (tracking macros)
}
