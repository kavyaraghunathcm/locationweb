package com.kavya.location.controller;

import com.kavya.location.entity.Location;
import com.kavya.location.service.LocationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocationContoller {
    @Autowired
    LocationService locationService;
    @RequestMapping("/showCreate")
        public String showCreate(){
            return "create-location";
    }


    @PostMapping("/saveLocation")
    public String saveLocation(@ModelAttribute Location location,  ModelMap modelMap){
        Location locationSaved=locationService.saveLocation(location);
        String msg= "Location saved with id"+ locationSaved.getId();
        modelMap.addAttribute("msg",msg);
        return "create-location";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap){
        modelMap.addAttribute("locations",locationService.getAllLocations());
        return "display-locations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap){
        Location location = locationService.getLocationById(id);
        locationService.deleteLocation(location);
        modelMap.addAttribute("locations",locationService.getAllLocations());
        return "display-locations";
    }
    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id,ModelMap modelMap){
        modelMap.addAttribute("location",locationService.getLocationById(id));
        return "update-location";
    }
    @PostMapping("/updateLocation")
    public String updateLocation(@ModelAttribute Location location,  ModelMap modelMap){
        locationService.saveLocation(location);
        modelMap.addAttribute("locations",locationService.getAllLocations());
        return "display-locations";
    }
}
