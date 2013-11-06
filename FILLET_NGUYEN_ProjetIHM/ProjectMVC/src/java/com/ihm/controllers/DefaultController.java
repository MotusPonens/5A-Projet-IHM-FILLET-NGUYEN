/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihm.controllers;

import com.ihm.contacts.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    public ContactManager cm= new ContactManager();
    
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String redirect(ModelMap map) {
        String script ="";
        script+="<script>\n" +
        "window.location.href='index';\n" +
        "</script>";
        map.put("script", script);
        return "redirect";
    }
    
    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("contactManager",cm);
        return "index";
    }

    @RequestMapping(value="/profile", method= RequestMethod.GET)
    public String profile(@RequestParam("id") int id, ModelMap map){
        Contact contact=cm.findContactById(id);
        
        if(contact==null){
            map.put("ID", id);
            return "contact_not_found";
        }
        
        map.put("Contact", contact);
        return "profile";
    }    
    
    @RequestMapping(value="/add-contact", method= RequestMethod.GET)
    public String addContact(ModelMap map){
        cm.createContact();
        String script="";
        script+="<script>\n";
        script+="window.location.href='profile?id="+(cm.getIdMax()-1)+"';\n";
        script+="</script>\n";
        map.put("script", script);
        return "redirect";
    }
    
    @RequestMapping(value="/delete-contact", method= RequestMethod.GET)
    public String deleteContact(@RequestParam("id") int id, ModelMap map){
        cm.removeContactById(id);
        String script="";
        script+="<script>\n";
        script+="window.location.href='index';\n";
        script+="</script>\n";
        map.put("script", script);
        return "redirect";
    }
    @RequestMapping(value="/modify-contact", method= RequestMethod.GET)
    public String modifyContact(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("date") String dateOfBirth,
            ModelMap map){
        
        Contact contact=cm.findContactById(id);
        contact.setName(name);
        contact.setSurname(surname);
        contact.setEmail(email);
        contact.setDate(dateOfBirth.substring(8, 10));
        contact.setMonth(dateOfBirth.substring(5, 7));
        contact.setYear(dateOfBirth.substring(0, 4));
        
        String script="";
        script+="<script>\n";
        script+="window.location.href='profile?id="+id+"';\n";
        script+="</script>\n";
        map.put("script", script);
        
        return "redirect";
    }
    
    @RequestMapping(value="/add-adress", method= RequestMethod.GET)
    public String addAdress(@RequestParam("id") int id,ModelMap map){
        cm.findContactById(id).addAdresse();
        String script="";
        script+="<script>\n";
        script+="window.location.href='profile?id="+id+"';\n";
        script+="</script>\n";
        map.put("script", script);
        return "redirect";
    }
    
    @RequestMapping(value="/delete-adress", method= RequestMethod.GET)
    public String deleteAdress(@RequestParam("id") int id,@RequestParam("num") int num, ModelMap map){
        cm.findContactById(id).removeAdress(num);
        String script="";
        script+="<script>\n";
        script+="window.location.href='profile?id="+id+"';\n";
        script+="</script>\n";
        map.put("script", script);
        return "redirect";
    }
    
    @RequestMapping(value="/modify-adress", method= RequestMethod.GET)
    public String modifyAdress(
            @RequestParam("cid") int contactId,
            @RequestParam("aid") int adressId,
            @RequestParam("number") String num,
            @RequestParam("street") String street,
            @RequestParam("pc") String pc,
            @RequestParam("city") String city,
            ModelMap map){
        
        Adress adress = cm.findContactById(contactId).getAdresses().get(adressId);
        
        adress.setNumber(num);
        adress.setPostalCode(pc);
        adress.setStreet(street);
        adress.setCity(city);
        
        String script="";
        script+="<script>\n";
        script+="window.location.href='profile?id="+contactId+"';\n";
        script+="</script>\n";
        map.put("script", script);
        return "redirect";
    }
}