/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihm.contacts;

import java.util.ArrayList;

/**
 *
 * @author nath
 */
public class Contact {
    private int id;
    private String name, surname, email;
    private String year, month, date;
    private boolean active;
    private ArrayList<Adress> adresses;
    
    public Contact(int id,String name, String surname, String email, String year, String month, String date){
        adresses=new ArrayList<Adress>();
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.year=year;
        this.month=month;
        this.date=date;
        active=true;
    }
    
    public String displayList(){
        String list=
        
        "<table border=\"1\" rules=\"all\">\n"+
        "<tr>\n"+
        "<th>N°</th>\n"+
        "<th>Rue</th>\n"+
        "<th>Code Postal</th>\n"+
        "<th>Ville</th>\n"+
        //"<th></th>\n"+
        "</tr>\n";
        
        //list+="<table border=\"1\">";
        if(adresses.isEmpty()){
            list+="<tr>\n<td>Aucune adresse</td>\n<tr>\n";
            list+="</table>\n";
            return list;
        }
        for(int i=0;i<adresses.size();i++){
            list+="<form name=\"input\" action=\"modify-adress\" method=\"get\">";
            list+="<tr>\n";
            list+="<input type=\"hidden\" name=\"cid\" value=\""+id+"\">";
            list+="<input type=\"hidden\" name=\"aid\" value=\""+i+"\">";
            list+="<td><input type=\"text\" name=\"number\" size=\"6\" maxlength=\"10\"  value=\""+adresses.get(i).getNumber()+"\"></td>\n";
            list+="<td><input type=\"text\" name=\"street\" size=\"30\" maxlength=\"30\" value=\""+adresses.get(i).getStreet()+"\"></td>\n";
            list+="<td><input type=\"text\" name=\"pc\" maxlength=\"5\" value=\""+adresses.get(i).getPostalCode()+"\"></td>\n";
            list+="<td><input type=\"text\" name=\"city\" maxlength=\"20\" value=\""+adresses.get(i).getCity()+"\"></td>\n";
            list+="<td><input type=\"submit\" value=\"Enregistrer\"></td>\n";
            list+="</form>";
            list+="<td><button type=\"button\" ";
            list+="onclick=\"window.location.href='delete-adress?id="+getId()+"&num="+i+"'\"";
            list+=">Supprimer</button></td>\n";
            list+="</tr>\n";
            
        }
        list+="</table>\n";
            
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getMonth() {
        return month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public ArrayList<Adress> getAdresses() {
        return adresses;
    }
    
    public void setAdresses(ArrayList<Adress> adresses) {
        this.adresses = adresses;
    }
    
    public void addAdresse(Adress newAdress){
        this.adresses.add(newAdress);
    }
    
    public void addAdresse(){
        this.adresses.add(new Adress("numéro", "rue", "code postal", "ville"));
    }
    
    public void removeAdress(int num){
        this.adresses.remove(num);
    }
}
